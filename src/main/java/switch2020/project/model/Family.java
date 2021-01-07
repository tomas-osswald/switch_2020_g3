package switch2020.project.model;


import java.util.*;

public class Family {

    // Attributes
    private List<FamilyMember> family;
    //private int familyID;
    private String familyName;
    private Date registrationDate;
    //private FamilyMember familyAdministrator;
    private int familyID;
    private List<FamilyMember> familyMembers = new ArrayList<>();
    private ArrayList<String> relationDesignations = new ArrayList<>();

    /********************** CONSTRUCTORS ***************/
    //Constructors
    public Family(int familyID) {
        this.familyID = familyID;
    }

    public Family() {
    }

    public Family(int ID, FamilyMember member){
        this.familyID = ID;
        this.familyMembers.add(member);
    }

    public Family(int familyID, ArrayList<FamilyMember> members) {
        if (members == null) {
            throw new IllegalArgumentException("Family can't be null");
        }
        if (familyID < 0) {
            throw new IllegalArgumentException("ID can't be a negative number");
        }
        this.familyID = familyID;
        this.familyMembers = members;
    }

    /**
     * Constructor for an empty Family, uses the current date as the registation date for the created family
     * @param familyName String with Name of the family to be created
     */
    public Family(String familyName) {
        if (!isNameValid(familyName)) throw new IllegalArgumentException("Invalid Name");
        this.familyMembers= new ArrayList<>();
        this.registrationDate = new Date();
        this.familyName = familyName; //.trim().toUpperCase() o nome da familia não deve necessitar do uppercase uma vez que a familia começa sempre por maiuscula
    }

    /**
     * Constructor for an empty family for registrations requiring a different registration date
     * @param familyName String with the name of the family to be created
     * @param registrationDate Date of the registration of the given family
     */
    public Family(String familyName, Date registrationDate) {
        if (!isNameValid(familyName)) throw new IllegalArgumentException("Invalid Name");
        if (!isDateValid(registrationDate)) throw new IllegalArgumentException("Invalid Registration Date");
        this.familyMembers= new ArrayList<>();
        this.registrationDate = registrationDate;
        this.familyName = familyName; //.trim().toUpperCase() o nome da familia não deve necessitar do uppercase uma vez que a familia começa sempre por maiuscula
    }

    // Validations

    private boolean isNameValid(String familyName){
        if(familyName==null||familyName.isBlank()||familyName.isEmpty()) return false;

        return true;
    }

    private boolean isDateValid(Date registrationDate){
        Date today = new Date();
        if(registrationDate.after(today)) return false; //means registration date is after current date
        return true;
    }

    /********************** GETTERS AND SETTERS **********************/

    public List<FamilyMember> getFamily() {

        return Collections.unmodifiableList(familyMembers);
    }

    // Get and Setter methods
    /**
     * Method to return family ID
     *
     * @return family ID
     */

    public int getFamilyID() {
        return familyID;
    }

    // Business methods


    /**
     * Method to find the index of a family member with a specific ID in the Family ArrayList
     *
     * @param familyMemberID Integer representing the ID to find
     * @return Int corresponding to the index of the family member that has the passed ID
     * @throws IllegalArgumentException if there is no family member with the passed ID
     */

    private int findFamilyMemberIndexByID(int familyMemberID) {
        int index = 0;
        for (FamilyMember member : this.familyMembers) {
            if (member.getID() == familyMemberID) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException("No family member with that ID was found");
    }

    /**
     * Method to verify if a given Family Member is Administrator
     *
     * @param familyMemberID Family Member ID to verify
     * @return boolean
     */

    public boolean isAdmin(int familyMemberID) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getFamilyMemberID() == familyMemberID)
                return familyMember.isAdmin();
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
    /*************************/


    private boolean checkIfVatExists(int vat) {

        ArrayList<Integer> vatList = new ArrayList();
        for ( FamilyMember member : familyMembers ) {
            vatList.add(member.getVatNumber());
        }
        for ( Integer nif : vatList) {
            if( nif == vat){
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

    public boolean addToRelationDesignationList(String relation) {
        return relationDesignations.add(relation);
    }

    /**
     * Method to add a Relation to A family Member
     *
     * @param familyMemberID FamilyMemberID of the member to be added a Relation
     * @param relation       Relation to be added
     * @return boolean
     */

    public boolean addRelationToFamilyMember(int familyMemberID, Relation relation) {
        FamilyMember familyMember = getFamilyMember(familyMemberID);

        familyMember.addRelation(relation);

        return true;
    }

    /**
     * Method to get a Famaly Member by ID
     *
     * @param familyMemberID FamilyMemberID to search
     * @return FamilyMember with given ID
     */

    private FamilyMember getFamilyMember(int familyMemberID) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getFamilyMemberID() == familyMemberID)
                return familyMember;
        }
        // If given ID is not present, a expection is throw
        throw new IllegalArgumentException("No family member with such ID");
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

    /**
     * Method return the number of Family Members in List -> relationsDesignations
     *
     * @return number of relation designations
     */

    public int numberOfRelationDesignations() {
        return this.relationDesignations.size();

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        final Family family1 = (Family) o;
        return this.getFamilyID() == family1.getFamilyID() && Objects.equals(this.getFamily(), family1.getFamily());
    }


    /********************** USER STORIES **********************/

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd String of the email address to add
     * @param familyMemberID Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */

    public boolean addEmail(String emailToAdd, int familyMemberID) {
        FamilyMember targetMember = familyMembers.get(findFamilyMemberIndexByID(familyMemberID));
        return targetMember.addEmail(emailToAdd);
    }

    public boolean addFamilyMember(String name, String birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city, Relation relationship){
        if(!checkIfVatExists(vat)){
            FamilyMember newFamilyMember = new FamilyMember(name, birthDate, phone, email, vat, street, codPostal, local, city, relationship);
            familyMembers.add(newFamilyMember);
            return true;
        } else {
            throw new IllegalArgumentException("Vat already exists in the Family");
        }
    }

}
