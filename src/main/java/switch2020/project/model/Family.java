package switch2020.project.model;


import java.util.ArrayList;

public class Family {
    private int familyID;
    private ArrayList<FamilyMember> family = new ArrayList();

    /********************** CONSTRUCTORS ***************/

    public Family() {
    }

    public Family(FamilyMember member1, FamilyMember member2) {
        family.add(member1);
        family.add(member2);
    }

    public Family(int familyID){
        this.familyID = familyID;
    }

    /********************** GETTERS AND SETTERS **********************/

    public ArrayList<FamilyMember> getFamily() {
        return family;
    }

    /**
     * Method to add a FamilyMember object to the ArrayList of FamilyMembers
     * @param member FamilyMember object to add
     */
    public void addFamilyMember(FamilyMember member) {
        family.add(member);
    }

    /**
     * Method to find the index of a family member with a specific ID in the Family ArrayList
     *
     * @param familyMemberID Integer representing the ID to find
     * @return Int corresponding to the index of the family member that has the passed ID
     * @throws IllegalArgumentException if there is no family member with the passed ID
     */
    private int findFamilyMemberIndexByID(int familyMemberID) {
        int index = 0;
        for (FamilyMember member : this.family) {
            if (member.getID() == familyMemberID) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException("No family member with that ID was found");
    }

    /*************************/

    public int getFamilyID(){
        return this.familyID;
    }

    private boolean checkIfVatExists(int vat) {

        ArrayList<Integer> vatList = new ArrayList();
        for ( FamilyMember member : family ) {
            vatList.add(member.getVatNumber());
        }
        for ( Integer nif : vatList) {
            if( nif == vat){
                return true;
            }
        }
        return false;
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
        return family.get(findFamilyMemberIndexByID(familyMemberID)).addEmail(emailToAdd);
    }

    public boolean addFamilyMember(String name, String birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city, Relationship relationship){
        if(!checkIfVatExists(vat)){
            FamilyMember newFamilyMember = new FamilyMember(name, birthDate, phone, email, vat, street, codPostal, local, city, relationship);
            family.add(newFamilyMember);
            return true;
        } else {
            throw new IllegalArgumentException("Vat already exists in the Family");
        }

    }

}
