package switch2020.project.model;


import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;
import switch2020.project.utils.FamilyMemberRelationDTO;

import java.util.ArrayList;

public class Application {

    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Family> families = new ArrayList(); //A alterar para Service - Batista
    private CategoryService categoryService = new CategoryService();
    private FamilyService familyService = new FamilyService();

    public Application() {
    }

    public Application(Family family) {
        this.familyService.addFamily(family);
    }



    public CategoryService getCategoryService() {
        return this.categoryService;
    }

    public FamilyService getFamilyService() {
        return this.familyService;
    }









 /*   public void addFamily(int familyID){
        this.families.add(Family);
    }
  */

    public Family getFamily(int familyID) {
        boolean exists = false;
        Family familyToGet = new Family();
        for (Family family : families) {
            if (family.getFamilyID() == familyID) {
                exists = true;
                familyToGet = family;
            }
        }
        if (!exists) {
            throw new IllegalArgumentException("There is no family with such ID");
        }
        return familyToGet;
    }


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
