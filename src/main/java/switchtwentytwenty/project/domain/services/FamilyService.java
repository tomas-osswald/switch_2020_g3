package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.DTOs.output.FamilyMemberRelationDTO;
import switchtwentytwenty.project.domain.DTOs.output.FamilyWithoutAdministratorDTO;
import switchtwentytwenty.project.domain.DTOs.output.MemberProfileDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.CustomCategory;
import switchtwentytwenty.project.domain.model.user_data.EmailAddress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FamilyService {

    // Attributes
    private List<Family> families = new ArrayList<>();

    // Constructors
    public FamilyService() {

    }

    public FamilyService(Family family) {
        this.families.add(family);
    }

    public int getFamilyListLenght() {
        return families.size();
    }

    // Business Methods

    /**
     * Method that generates an ID for a Family
     *
     * @return generated ID
     */

    private int generateFamilyID() {
        int maxID = 0;
        for (Family family : this.families) {
            if (maxID < family.getFamilyID()) maxID = family.getFamilyID();
        }
        return maxID + 1;
    }

    public List<CustomCategory> getCustomCategories(int familyID) {
        Family family = getFamily(familyID);
        return family.getFamilyCustomCategories();
    }

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd String of the email address to add
     * @param familyID   Integer representing the family's ID
     * @param ccNumber   Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID

    public boolean addEmail(String emailToAdd, int familyID, String ccNumber) {
    if (!checkIfEmailPresent(emailToAdd)) {
    Family targetFamily = this.families.get(findFamilyIndexByID(familyID));
    return targetFamily.addEmail(emailToAdd, ccNumber);
    }
    throw new IllegalArgumentException("This email is already present");
    }
     */

    /*
     * Method to find the index of a family with a specific ID in the Families ArrayList
     *
     * @param familyID Integer representing the ID to find
     * @return Int corresponding to the index of the family  that has the passed ID
     * @throws IllegalArgumentException if there is no family with the passed ID

    private int findFamilyIndexByID(int familyID) {
        int index = 0;
        for (Family family : this.families) {
            if (family.isIDOfThisFamily(familyID)) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException("No family with that ID was found");
    }
     */

    /**
     * Method to check if a given email address is already present in the ArrayList of EmailAddress objects
     *
     * @param emailToCheck String representing the email address to check if present
     * @return True if the passed email address is already present
     */
    private boolean checkIfEmailPresent(String emailToCheck) {
        List<FamilyMember> allFamilyMembers = new ArrayList();
        List<EmailAddress> allEmails = new ArrayList();
        for (Family family : this.families) {
            allFamilyMembers.addAll(family.getFamilyMembers());

        }
        for (FamilyMember familyMember : allFamilyMembers) {
            allEmails.addAll(familyMember.getEmails());

        }

        for (EmailAddress email : allEmails) {
            if (email.getEmail().equalsIgnoreCase(emailToCheck)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Method to add a Family to Families List -> families
     *
     * @param family Family to add
     */

    public void addFamily(Family family) {
        this.families.add(family);
    }

    public boolean addFamily(String familyName) {
        try {
            int familyID = generateFamilyID();
            Family newFamily = new Family(familyName, familyID);
            families.add(newFamily);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }


    /**
     * Method to get a family by ID in families
     *
     * @param familyID FamilyID of required family
     * @return Family instance
     */
    public Family getFamily(int familyID) {
        if (checkIfFamilyExists(familyID)) {
            for (Family family : families) {
                if (family.getFamilyID() == familyID)
                    return family;
            }
        } else {
            throw new IllegalArgumentException("No family with such ID");
        }
        return null;
    }

    private boolean checkIfFamilyExists(int familyID) {
        for (Family family : families) {
            if (familyID == family.getFamilyID()) {
                return true;
            }
        }
        return false;
    }

    public boolean addFamilyMember(String selfCC, String cc, String name, Date birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, int familyID) {
        if (checkIfFamilyExists(familyID)) {
            int posicaoFamilia = this.families.indexOf(getFamily(familyID));
            if (this.families.get(posicaoFamilia).verifyAdministrator(selfCC)) {
                if (!checkIfEmailPresent(email)) {
                    this.families.get(posicaoFamilia).addFamilyMember(cc, name, birthDate, phone, email, vat, street, codPostal, local, city);
                    return true;
                }
                throw new IllegalArgumentException("This email already exists");
            }
            throw new IllegalArgumentException("This user is not Administrator");
        }
        throw new IllegalArgumentException("Family does not exist");
    }

    public boolean addFamilyAdministrator(String ccNumber, String name, Date birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, int familyID) {
        if (checkIfFamilyExists(familyID)) {
            if (!checkIfEmailPresent(email)) {
                int posicaoFamilia = this.families.indexOf(getFamily(familyID));
                this.families.get(posicaoFamilia).addFamilyAdministrator(ccNumber, name, birthDate, phone, email, vat, street, codPostal, local, city);
                return true;
            }
            throw new IllegalArgumentException("This email already exists");
        }
        throw new IllegalArgumentException("Family does not exist");
    }

   /* //Temporariamente comentado para não ter conflito até se decidir se retorna null ou exception
    private Family getFamily(int familyID){
        for (Family familia : families ) {
            if(familyID == familia.getFamilyID())
                return familia;
        }
        return null;
    } */


    public boolean verifyAdministratorPermission(int familyID, String ccNumber) {
        Family family = getFamily(familyID);
        boolean isAdmin = family.verifyAdministrator(ccNumber);
        return isAdmin;
    }

    /**
     * Method to convert the FamilyMembers of a determined family previously obtained by the familyID.
     * With the familyID the method delegates to the Family Class the responsibility of returning a List of DTOs from
     * the Family's Family Members. If the User isn't the Family Administrator the return is an Empty List.
     *
     * @param familyID      representing the Id of the family to find.
     * @param adminCCNumber representing the userID. Has to be verified in order to provide access to the information
     * @return DTOList containing Family Members' name and the relationDesignation.
     */

    public List<FamilyMemberRelationDTO> getFamilyMembersRelationDTOList(int familyID, String adminCCNumber) {
        List<FamilyMemberRelationDTO> DTOList = new ArrayList<>();
        Family family = getFamily(familyID);
        if (family.verifyAdministrator(adminCCNumber)) {
            DTOList = family.getFamilyMembersRelationDTOList();
        }
        return DTOList;
    }


    /**
     * Using the familyID the method iterates through the list of families
     * and after finding the correct family iterates through the list of
     * family members to find the family member which profile has been
     * requested. The profile is the returned as a MemberProfileDTO
     *
     * @param familyId representing the unique ID given to each family
     * @param ccNumber representing the unique ID from each family member
     * @return MemberProfileDTO with member's attributes
     */
    public MemberProfileDTO getFamilyMemberProfile(int familyId, String ccNumber) {

        Family family = getFamily(familyId);
        return family.getFamilyMemberProfile(ccNumber);
    }

    /**
     * Method to return a List of Families without Administrator
     *
     * @return List<FamilyWithoutAdministratorDTO>
     */

    public List<FamilyWithoutAdministratorDTO> familiesWithoutAdministrator() {
        List<FamilyWithoutAdministratorDTO> listOfFamiliesWithoutAdministrator = new ArrayList<>();

        for (Family family : families) {
            if (!family.hasAdministrator()) {
                FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO = family.familyWithoutAdministratorDTO();
                listOfFamiliesWithoutAdministrator.add(familyWithoutAdministratorDTO);
            }
        }
        return listOfFamiliesWithoutAdministrator;
    }

    public boolean checkIfEmailAlreadyRegisteredInApp(String emailToAdd) {
        List<EmailAddress> allEmails = new ArrayList<>();
        for (Family family : families) {
            List<FamilyMember> members = family.getFamilyMembers();
            for (FamilyMember member : members) {
                allEmails.addAll(member.getEmails());
            }
        }
        for (EmailAddress email : allEmails) {
            if (emailToAdd.equalsIgnoreCase(email.getEmail())) {
                return true;
            }
        }
        return false;
    }

    /*
    //Custom Parent
    public boolean addCategory(int familyID, String designation, int parentID) {
        return getFamily(familyID).addCustomCategory(designation, parentID);
    }

    //Standard Parent
    public boolean addCategory(int familyID, String designation, StandardCategory parent) {
        if(parent==null){
            throw new IllegalArgumentException("Expected StandardCategory parent but is null");
        }
        return getFamily(familyID).addCustomCategory(designation, parent);
    }
    //No Parent
    public boolean addCategory(int familyID, String designation) {
        return getFamily(familyID).addCustomCategory(designation);
    }

 */

}

