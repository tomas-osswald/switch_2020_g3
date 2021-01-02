package switch2020.project.model;

import switch2020.project.utils.FamilyMemberRelationshipDTO;

import java.util.ArrayList;


public class Application {

    private ArrayList<Family> families = new ArrayList();
    private ArrayList<Category> categories = new ArrayList();

    public Application(Family initialFamily) {
        ArrayList<Family> initialFamilies = new ArrayList<>();
        initialFamilies.add(initialFamily);
        this.families = initialFamilies;
    }

    public Application(ArrayList<Family> families) {
        this.families = families;
    }

 /*   public void addFamily(int familyId){
        this.families.add(Family);
    }

  */

    public Family getFamily(int familyId) {
        boolean exists = false;
        Family familyToGet = new Family();
        for (Family family : families) {
            if (family.getID() == familyId) {
                exists = true;
                familyToGet = family;
            }
        }
        if (!exists) {
            throw new IllegalArgumentException("There is no family with such ID");
        }
        return familyToGet;
    }

    /*Testar throw para o caso de o ID não se encontrar dentro da lista de famílias armazenadas na
    aplicação */

  /*  public ArrayList<FamilyMember> getFamilyMembers(int familyId) {
        ArrayList<FamilyMember> members = new ArrayList<>();
        boolean exists = false;
        for (Family family : families) {
            if (family.getID() == familyId) {
                exists = true;
            }
        }
        if (exists == true) {
            for (Family family : families) {
                if (family.getID() == familyId) {
                    members = family.getMembers();
                }
            }
        } else {
            throw new IllegalArgumentException("There is no family with such ID");
        }
        return members;
    } */

    public ArrayList<FamilyMember> getFamilyMembers(int familyId) {
        Family family = getFamily(familyId);
        return family.getMembers();
    }


    public ArrayList<FamilyMemberRelationshipDTO> getDTOList(int familyId) {
        ArrayList<FamilyMember> members = getFamily(familyId).getMembers();
        ArrayList<FamilyMemberRelationshipDTO> DTOList = new ArrayList<>();
        for (FamilyMember member : members) {
            String name = member.getName();
            String relationship = member.getRelationship();
            FamilyMemberRelationshipDTO newMember = new FamilyMemberRelationshipDTO(name, relationship);
            DTOList.add(newMember);
        }
        return DTOList;
    }



}
