package switch2020.project.model;

import switch2020.project.utils.FamilyMemberRelationDTO;

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

 /*   public void addFamily(int familyID){
        this.families.add(Family);
    }
  */

    public Family getFamily(int familyID) {
        boolean exists = false;
        Family familyToGet = new Family();
        for (Family family : families) {
            if (family.getID() == familyID) {
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

  /*  public ArrayList<FamilyMember> getFamilyMembers(int familyID) {
        ArrayList<FamilyMember> members = new ArrayList<>();
        boolean exists = false;
        for (Family family : families) {
            if (family.getID() == familyID) {
                exists = true;
            }
        }
        if (exists == true) {
            for (Family family : families) {
                if (family.getID() == familyID) {
                    members = family.getMembers();
                }
            }
        } else {
            throw new IllegalArgumentException("There is no family with such ID");
        }
        return members;
    } */

    public ArrayList<FamilyMember> getFamilyMembers(int familyID) {
        Family family = getFamily(familyID);
        return family.getMembers();
    }


    public ArrayList<FamilyMemberRelationDTO> getDTOList(int familyID) {
        ArrayList<FamilyMember> members = getFamily(familyID).getMembers();
        ArrayList<FamilyMemberRelationDTO> DTOList = new ArrayList<>();
        for (FamilyMember member : members) {
            String name = member.getName();
            String relation = member.getRelation();
            FamilyMemberRelationDTO newMember = new FamilyMemberRelationDTO(name, relation);
            DTOList.add(newMember);
        }
        return DTOList;
    }



}
