package switch2020.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Family {

    private List<FamilyMember> family;
    //private int familyID;
    private String familyName;
    private Date registrationDate;
    //private FamilyMember familyAdministrator;

    /**
     * Constructor for an empty Family, uses the current date as the registation date for the created family
     * @param familyName String with Name of the family to be created
     */
    public Family(String familyName) {
        if (!isNameValid(familyName)) throw new IllegalArgumentException("Invalid Name");
        this.family= new ArrayList<>();
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
        this.family= new ArrayList<>();
        this.registrationDate = registrationDate;
        this.familyName = familyName; //.trim().toUpperCase() o nome da familia não deve necessitar do uppercase uma vez que a familia começa sempre por maiuscula
    }

    private boolean isNameValid(String familyName){
        if(familyName==null||familyName.isBlank()||familyName.isEmpty()) return false;

        return true;
    }

    private boolean isDateValid(Date registationDate){
        Date today = new Date();
        if(registrationDate.after(today)) return false; //means registration date is after current date
        return true;
    }

//    public boolean isFamilyEmpty(){ return family.isEmpty();}

//    private boolean hasAdministrator(){ }














    public List<FamilyMember> getFamily() {
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
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd String of the email address to add
     * @param familyMemberID Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */
    public boolean addEmail(String emailToAdd, int familyMemberID) {
        return family.get(findFamilyMemberIndexByID(familyMemberID)).addEmail(emailToAdd);
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

}
