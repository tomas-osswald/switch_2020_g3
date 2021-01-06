package switch2020.project.model;


import java.util.ArrayList;

public class Family {
    private ArrayList<FamilyMember> members = new ArrayList();
    private int familyID;

    public Family(int familyID) {
        this.familyID = familyID;
    }

    public Family(int familyID, FamilyMember member1, FamilyMember member2) {
        this.familyID = familyID;
        members.add(member1);
        members.add(member2);
    }

    public int getFamilyID() {
        return familyID;
    }

    public ArrayList<FamilyMember> getMembers() {
        return members;
    }

    /**
     * Method to add a FamilyMember object to the ArrayList of FamilyMembers
     *
     * @param member FamilyMember object to add
     */
    public void addFamilyMember(FamilyMember member) {
        members.add(member);
    }

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd     String of the email address to add
     * @param familyMemberID Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */
    public boolean addEmail(String emailToAdd, int familyMemberID) {
        return members.get(findFamilyMemberIndexByID(familyMemberID)).addEmail(emailToAdd);
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
        for (FamilyMember member : this.members) {
            if (member.getID() == familyMemberID) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException("No family member with that ID was found");
    }

}
