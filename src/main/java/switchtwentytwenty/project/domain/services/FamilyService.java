package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.dtos.output.FamilyMemberRelationDTO;
import switchtwentytwenty.project.domain.dtos.output.FamilyWithoutAdministratorDTO;
import switchtwentytwenty.project.domain.dtos.output.MemberProfileDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.categories.CustomCategory;
import switchtwentytwenty.project.domain.model.user_data.CCNumber;
import switchtwentytwenty.project.domain.model.user_data.EmailAddress;

import java.util.ArrayList;
import java.util.List;

public class FamilyService {

    // Attributes
    private final List<Family> families = new ArrayList<>();

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





    /*Methods de teste a manter um method público para ser
    invocado e um method private para processamento/lógica de negócio*/

    /**
     * Method to check if a given email address is already present in the ArrayList of EmailAddress objects
     *
     * @param emailToCheck String representing the email address to check if present
     * @return True if the passed email address is already present
     */
    public void checkIfEmailIsUnique(String emailToCheck) {
        EmailAddress newEmail = new EmailAddress(emailToCheck);
        checkIfEmailIsUnique(newEmail);
    }

     /*Methods de teste a manter um method público para ser
    invocado e um method private para processamento/lógica de negócio*/

    //TODO: Confirmar junto do prof. se a lógica está bem aplicada (um public e um private)
    private void checkIfEmailIsUnique(EmailAddress newEmail) {
        for (Family family : this.families) {
            if (family.isEmailPresentInFamily(newEmail)) {
                throw new IllegalArgumentException("Email already registered in App");
            }
        }
    }


    /**
     * Method to add a Family to Families List -> families
     *
     * @param family Family to add
     */
    @Deprecated
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
        if (!checkIfFamilyExists(familyID)) throw new IllegalArgumentException("No family with such ID");
        Family selectedFamily = null;
        for (Family family : families) {
            if (family.isIDofThisFamily(familyID))
                selectedFamily = family;
        }
        return selectedFamily;
    }

    private boolean checkIfFamilyExists(int familyID) {
        for (Family family : families) {
            if (family.isIDofThisFamily(familyID)) {
                return true;
            }
        }
        return false;
    }

    public boolean addFamilyMember(AddFamilyMemberDTO familyMemberDTO) {
        Family family = getFamily(familyMemberDTO.getFamilyID());
        if (family.verifyAdministrator(familyMemberDTO.getSelfCCNumber())) {
            checkIfEmailIsUnique(familyMemberDTO.getEmail());
            family.addFamilyMember(familyMemberDTO);
            return true;
        }
        throw new IllegalArgumentException("This user is not Administrator");
    }

    public boolean addFamilyAdministrator(AddFamilyMemberDTO familyMemberDTO) {
        checkIfEmailIsUnique(familyMemberDTO.getEmail());
        Family family = getFamily(familyMemberDTO.getFamilyID());
        family.addFamilyAdministrator(familyMemberDTO);
        return true;
    }


    /**
     * Method to verify if a given FamilyMember is the Administrator of the given Family.
     *
     * @param familyID representing the Id of the family to find.
     * @param ccNumber representing the userID.
     * @return true if it's Administrator, if not, false.
     */
    public boolean verifyAdministratorPermission(int familyID, String ccNumber) {
        Family family = getFamily(familyID);
        return family.verifyAdministrator(ccNumber);
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
        List<FamilyMemberRelationDTO> familyMembersRelation = new ArrayList<>();
        Family family = getFamily(familyID);
        if (family.verifyAdministrator(adminCCNumber)) {
            familyMembersRelation = family.getFamilyMembersRelationDTOList();
        }
        return familyMembersRelation;
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
        CCNumber cc = new CCNumber(ccNumber);
        Family family = getFamily(familyId);
        return family.getFamilyMemberProfile(cc);
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


    public FamilyMember getFamilyMemberByFamilyAndMemberId(int familyID, String familyMemberID) {
        Family family = getFamily(familyID);
        CCNumber cc = new CCNumber(familyMemberID);
        return family.getFamilyMemberByID(cc);
    }
}

