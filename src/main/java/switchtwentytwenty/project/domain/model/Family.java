package switchtwentytwenty.project.domain.model;

import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.dtos.output.FamilyMemberRelationDTO;
import switchtwentytwenty.project.domain.dtos.output.FamilyWithoutAdministratorDTO;
import switchtwentytwenty.project.domain.dtos.output.MemberProfileDTO;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.CustomCategory;

import java.util.*;

public class Family {

    // Attributes

    private int familyID;
    private String familyName;
    private Date registrationDate;
    //private FamilyMember familyAdministrator;
    private List<FamilyMember> familyMembers;
    private List<String> relationDesignations = new ArrayList<>();
    private Account familyCashAccount = null;
    private List<CustomCategory> familyCustomCategories = new ArrayList<>();
    private List<Relation> familyRelations = new ArrayList<>();

    /********************** CONSTRUCTORS ***************/
    //Constructors

    /**
     * Constructor for an empty Family, uses the current date as the registration date for the created family
     *
     * @param familyName String with Name of the family to be created
     */
    public Family(String familyName, int familyID) {
        if (!isNameValid(familyName)) throw new IllegalArgumentException("Invalid Name");
        this.familyMembers = new ArrayList<>();
        this.registrationDate = new Date();
        this.familyName = familyName;
        this.familyID = familyID;
    }
/*
    /**
     * Constructor for an empty family for registrations requiring a different registration date
     * @param familyName String with the name of the family to be created
     * @param registrationDate Date of the registration of the given family

    public Family(String familyName, Date registrationDate, int familyID) {
        if (!isNameValid(familyName)) throw new IllegalArgumentException("Invalid Name");
        if (!isDateValid(registrationDate)) throw new IllegalArgumentException("Invalid Registration Date");
        this.familyMembers = new ArrayList<>();
        this.registrationDate = registrationDate;
        this.familyName = familyName;
        this.familyID = familyID;
    }
*/
    // Validations

    private boolean isNameValid(String familyName) {
        if (familyName == null || familyName.trim().length() == 0 || familyName.isEmpty()) return false;

        return true;
    }

    /********************** GETTERS AND SETTERS **********************/

    public List<FamilyMember> getFamilyMembers() {

        return Collections.unmodifiableList(familyMembers);
    }

    /**
     * Method to return family ID
     *
     * @return family ID
     */

    public int getFamilyID() {
        return familyID;
    }

    public List<CustomCategory> getFamilyCustomCategories() {
        List<CustomCategory> familyCustomCategoriesClone = this.familyCustomCategories;
        return familyCustomCategoriesClone;
    }

    // Business methods

    /*
     * Method that compares a given ID is equal to the ID of this family
     *
     * @param familyID int the familyID you wish to compare
     * @return true if the IDs match, otherwise false
     *
    public boolean isIDOfThisFamily(int familyID) {
        return familyID == this.familyID;
    }
    */

    /**
     * Method to verify if a given Family Member is Administrator
     *
     * @param ccNumber Family Member ID to verify
     * @return boolean
     */
    public boolean verifyAdministrator(String ccNumber) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.compareID(ccNumber))
                return familyMember.isAdministrator();
        }
        return false;
    }

    /**
     * Method to verify if a given relation designation has been already added to a list os given relation designations
     *
     * @param relationDesignation String with the designation of the relation
     * @return boolean
     */

    public boolean hasDesignation(String relationDesignation) {
        for (String relationDesigantion : relationDesignations) {
            if (relationDesigantion.toLowerCase().equals(relationDesignation.toLowerCase()))
                return true;
        }
        return false;
    }

    private boolean checkIfVatExists(int vat) {
        ArrayList<Integer> vatList = new ArrayList();
        for (FamilyMember member : familyMembers) {
            vatList.add(member.getVatNumber());
        }
        for (Integer nif : vatList) {
            if (nif == vat) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfCCNumberExists(String cc) {
        ArrayList<String> ccList = new ArrayList();
        for (FamilyMember member : familyMembers) {
            ccList.add(member.getFamilyMemberID());
        }
        for (String ccNumber : ccList) {
            if (ccNumber.equals(cc)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to add a relation designation to list of relation designations
     *
     * @param relation String relation designation
     * @return boolean
     */

    public void addToRelationDesignationList(String relation) {
        relationDesignations.add(relation);
    }

    /**
     * Method to add a Relation to A family Member
     *
     * @param ccNumber            FamilyMemberID of the member to be added a Relation
     * @param relationDesignation Relation Designation to be added
     * @return boolean
     */


    /**
     * Method to get a Family Member by ID
     *
     * @param ccNumber FamilyMemberID to search
     * @return FamilyMember with given ID
     */

    public FamilyMember getFamilyMemberByID(String ccNumber) {
        if (!checkIfCCNumberExists(ccNumber)) throw new IllegalArgumentException("No family member with such ID");
        FamilyMember selectedFamilyMember = null;
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.compareID(ccNumber))
                selectedFamilyMember = familyMember;
        }
        return selectedFamilyMember;
    }

    /**
     * Method to add a Family Member to list of FamilyMembers
     *
     * @param familyMember FamilyMember to add to list
     */

    public void addFamilyMember(FamilyMember familyMember) {
        this.familyMembers.add(familyMember);
    }

    /**
     * Method to add a Family Member Array to list of FamilyMembers
     *
     * @param familyMembers FamilyMember arry to add to list
     */

    public void addFamilyMemberArray(ArrayList<FamilyMember> familyMembers) {
        this.familyMembers.addAll(familyMembers);
    }

    /**
     * Method return the number of Family Members in List -> familyMembers
     *
     * @return number of Family Members
     */

    public int numberOfFamilyMembers() {
        return this.familyMembers.size();
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Family)) return false;
        Family otherFamily = (Family) other;
        return (this.familyID == otherFamily.familyID && this.familyName.equals(otherFamily.familyName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyID, familyName, registrationDate, familyMembers, relationDesignations, familyCashAccount, familyCustomCategories, familyRelations);
    }


    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     * <p>
     * emailToAdd String of the email address to add
     * ccNumber   Integer representing the family member's ID
     *
     * @return True if email successfully added to the Family Member with the passed ID
     * <p>
     * <p>
     * public boolean addEmail(String emailToAdd, String ccNumber) {
     * FamilyMember targetMember = familyMembers.get(findFamilyMemberIndexByID(ccNumber));
     * return targetMember.addEmail(emailToAdd);
     * }
     */

    public boolean addFamilyMember(AddFamilyMemberDTO familyMemberDTO) {
        if (!checkIfVatExists(familyMemberDTO.getVat())) {
            if (!checkIfCCNumberExists(familyMemberDTO.getCc())) {
                FamilyMember newFamilyMember = new FamilyMember(familyMemberDTO.getCc(), familyMemberDTO.getName(), familyMemberDTO.getBirthDate(), familyMemberDTO.getPhone(), familyMemberDTO.getEmail(), familyMemberDTO.getVat(), familyMemberDTO.getStreet(), familyMemberDTO.getCodPostal(), familyMemberDTO.getLocal(), familyMemberDTO.getCity());
                familyMembers.add(newFamilyMember);
                return true;
            } else {
                throw new IllegalArgumentException("ccNumber already exists in the Family");
            }
        } else {
            throw new IllegalArgumentException("Vat already exists in the Family");
        }
    }

    public boolean addFamilyAdministrator(String ccNumber, String name, Date birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city) {
        boolean administrator = true;
        if (!checkIfVatExists(vat)) {
            FamilyMember newFamilyMember = new FamilyMember(ccNumber, name, birthDate, phone, email, vat, street, codPostal, local, city, administrator);
            familyMembers.add(newFamilyMember);
            return true;
        } else {
            throw new IllegalArgumentException("Vat already exists in the Family");
        }
    }

    /**
     * Method that returns if a cash account has already been created for a this family
     *
     * @return returns true if a cash account already exists
     */

    public boolean hasCashAccount() {
        boolean hasCashAccount = false;
        if (this.familyCashAccount != null) {
            hasCashAccount = true;
        }
        return hasCashAccount;
    }


    /**
     * This method is called by the Family Service, which confirms the Administrator Permission and if the user has permission
     * it iterates through the familyMembers and each one of them will create a copy of himself, with
     * (FamilyMemberRelationDTO) the name and the relationDesignation. Every object is stored in the FMRList.
     * Returns said List back to the Family Service.
     *
     * @return List of FamilyMembersRelationDTO
     */
    // Changes to method IOT get a DTO directly from the FamilyMember
    public List<FamilyMemberRelationDTO> getFamilyMembersRelationDTOList() {
        List<FamilyMemberRelationDTO> DTOList = new ArrayList<>();
        for (Relation relation : familyRelations) {
            FamilyMemberRelationDTO relationDTO = new FamilyMemberRelationDTO(relation);
            DTOList.add(relationDTO);
        }
        return DTOList;
    }


    /**
     * Method to verify if a Family has an administrator
     *
     * @return boolean
     */

    public boolean hasAdministrator() {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.isAdministrator())
                return true;
        }
        return false;
    }

    /**
     * Method to create a DTO (familyWithoutAdministratorDTO) with name and id of a Family
     *
     * @return aFamilyWithoutAdministratorDTO
     */

    public FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO() {
        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO = new FamilyWithoutAdministratorDTO(this.familyName, this.familyID);
        return familyWithoutAdministratorDTO;
    }

    /**
     * Method iterates through list of family members and finding the correct
     * one, creates a profile based on the attributes of the family member
     *
     * @param ccNumber representing the unique ID from each family member
     * @return MemberProfileDTO with member's attributes
     */
    public MemberProfileDTO getFamilyMemberProfile(String ccNumber) {

        FamilyMember familyMember = getFamilyMemberByID(ccNumber);
        MemberProfileDTO memberProfile = familyMember.createProfile();
        return memberProfile;
    }

    /*
    //Custom parent
    public boolean addCustomCategory(String designation, int parentID) {
        int categoryID = generateCustomCategoryID();
        CustomCategory parent = getCustomCategoryByID(parentID);
        if (parent == null) {
            throw new IllegalArgumentException("Expected CustomCategoryParent but was null");
        }
        CustomCategory newCategory = new CustomCategory(designation, parent, categoryID);
        familyCustomCategories.add(newCategory);
        return true;
    }

    //Standard parent
    public boolean addCustomCategory(String designation, StandardCategory parent) {
        int categoryID = generateCustomCategoryID();
        CustomCategory newCategory = new CustomCategory(designation, parent, categoryID);
        familyCustomCategories.add(newCategory);
        return true;
    }

    //No parent
    public boolean addCustomCategory(String designation) {
        int categoryID = generateCustomCategoryID();
        StandardCategory parent = null;
        CustomCategory newCategory = new CustomCategory(designation, parent, categoryID);
        familyCustomCategories.add(newCategory);
        return true;
    }
*/

    /**
     * This method returns a CustomCategory of a given ID
     *
     * @param categoryID ID of the CustomCategory to be returned
     * @return chosen CustomCategory, if the CustomCategory is not found returns null;
     */

    public CustomCategory getCustomCategoryByID(int categoryID) {
        CustomCategory selectedCategory = null;
        int size = this.familyCustomCategories.size();
        for (int index = 0; index < size; index++) {
            if (this.familyCustomCategories.get(index).getCategoryID() == categoryID) {
                selectedCategory = this.familyCustomCategories.get(index);
                index = size;
            }
        }
        return selectedCategory;
    }

    public FamilyMember getFamilyMember(String ccNumber) {
        for (FamilyMember member : this.familyMembers) {
            if (member.compareID(ccNumber)) {
                return member;
            }
        }
        return null;
    }

    public void addCashAccount(Account newCashAccount) {
        this.familyCashAccount = newCashAccount;
    }

    public boolean addCategory(CustomCategory newCustomCategory) {
        this.familyCustomCategories.add(newCustomCategory);
        return true;
    }


    public boolean addRelation(Relation newRelation) {
        Relation oldRelation = checkIfMembersHaveRelationAndGetIt(newRelation);
        if (oldRelation != null) {
            familyRelations.remove(oldRelation);
        }
        familyRelations.add(newRelation);
        return true;
    }

    private Relation checkIfMembersHaveRelationAndGetIt(Relation newRelation) {
        Relation selectedRelation = null;
        for (Relation relation : familyRelations) {
            if (relation.getMemberA().equals(newRelation.getMemberA()) && relation.getMemberB().equals(newRelation.getMemberB()))
                selectedRelation = relation;
        }
        return selectedRelation;
    }

    public boolean isAParentOfB(FamilyMember memberA, FamilyMember memberB) {
        boolean parenthood = false;
        for (Relation relation : familyRelations) {
            if (relation.getMemberA().equals(memberA) && relation.getMemberB().equals(memberB)) {
                parenthood = relation.isAParentOfB();
            }
        }
        return parenthood;
    }


    public Account getFamilyCashAccount() {
        return this.familyCashAccount;
    }

//    public String getFamilyName() {
//        return familyName;
//    }

}