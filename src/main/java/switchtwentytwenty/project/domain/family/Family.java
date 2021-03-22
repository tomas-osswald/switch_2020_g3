package switchtwentytwenty.project.domain.family;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.EmailAddress;
import switchtwentytwenty.project.shared.FamilyID;
import switchtwentytwenty.project.shared.FamilyName;
import switchtwentytwenty.project.shared.RegistrationDate;

import java.util.Objects;

public class Family implements AggregateRoot {

    private final FamilyID id;
    private final FamilyName name;
    private final RegistrationDate registrationDate;
    private EmailAddress adminEmail;

    public Family(FamilyID familyID,FamilyName familyName, RegistrationDate registrationDate, EmailAddress adminEmail) {
        this.id = familyID;
        this.name = familyName;
        this.registrationDate = registrationDate;
        this.adminEmail = adminEmail;
    }

    public boolean isIDofThisFamily(FamilyID familyID) {
        return this.id.equals(familyID);
    }


/*
    public int getFamilyID() {
        return familyID;
    }

    // Business methods

    /**
     * Method to verify if a Family has an administrator
     *
     * @return boolean
     */
/*
    public boolean hasAdministrator() {
        return this.adminEmail.notNull()
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
*/



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return id.equals(family.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
