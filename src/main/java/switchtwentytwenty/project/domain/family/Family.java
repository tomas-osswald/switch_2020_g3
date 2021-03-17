package switchtwentytwenty.project.domain.family;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.FamilyID;
import switchtwentytwenty.project.shared.FamilyName;

import java.time.LocalDate;

public class Family implements AggregateRoot {

    //private final FamilyID id;
    //private final FamilyName name;
    //private final LocalDate registrationDate; //Verificar classe a ser usada para representar a data
    //private Email adminEmail;

    public Family(FamilyName familyName, LocalDate registrationDate, FamilyID familyID) {

    }


/*
    public int getFamilyID() {
        return familyID;
    }

    public boolean isIDofThisFamily(int familyID) {
        return this.familyID == familyID;
    }

    // Business methods

    /**
     * Method to verify if a Family has an administrator
     *
     * @return boolean
     */
/*
    public boolean hasAdministrator() {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.isAdministrator())
                return true;
        }
        return false;
    }
*/
    /**
     * Method to verify if a given Family Member is Administrator
     *
     * @param ccNumber Family Member ID to verify
     * @return boolean
     */
/*
    public boolean verifyAdministrator(String ccNumber) {
        CCNumber cc = new CCNumber(ccNumber);
        boolean result = false;
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.compareID(cc))
                result = familyMember.isAdministrator();
        }
        return result;
    }

    public boolean addFamilyAdministrator(AddFamilyMemberDTO familyMemberDTO) {
        boolean administrator = true;
        VatNumber vat = new VatNumber(familyMemberDTO.getVat());
        if (!checkIfVATisUniqueInApp(vat)) {
            FamilyMember newFamilyMember = new FamilyMember(familyMemberDTO.getCc(), familyMemberDTO.getName(), familyMemberDTO.getBirthDate(), familyMemberDTO.getPhone(), familyMemberDTO.getEmail(), familyMemberDTO.getVat(), familyMemberDTO.getStreet(), familyMemberDTO.getCodPostal(), familyMemberDTO.getLocal(), familyMemberDTO.getCity(), administrator);
            familyMembers.add(newFamilyMember);
            return true;
        } else {
            throw new IllegalArgumentException("Vat already exists in the Family");
        }
    }
*/
// FAMILY TO DTO?
    /**
     * Method to create a DTO (familyWithoutAdministratorDTO) with name and id of a Family
     *
     * @return aFamilyWithoutAdministratorDTO
     */
/*
    public FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO() {
        return new FamilyWithoutAdministratorDTO(this.familyName, this.familyID);
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
        return Objects.hash(familyID, familyName, relationDesignations, familyCashAccount, familyCustomCategories, familyRelations);
    }
*/
}
