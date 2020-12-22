package switch2020.project.model;


import java.util.ArrayList;

public class Family {
    private ArrayList<FamilyMember> family = new ArrayList();

    public Family() {
    }

    public Family(FamilyMember member1, FamilyMember member2) {
        family.add(member1);
        family.add(member2);
    }

    public void addFamilyMember(FamilyMember member) {
        family.add(member);
    }

    public boolean addEmail(String emailToAdd, int familyMemeberID) {
        return family.get(findFamilyMemberIndexByID(familyMemeberID)).addEmail(emailToAdd);
    }


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
