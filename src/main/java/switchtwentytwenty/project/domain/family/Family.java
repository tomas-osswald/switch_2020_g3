package switchtwentytwenty.project.domain.family;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.domain.person.Person;
import switchtwentytwenty.project.shared.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Family implements AggregateRoot {

    private final FamilyID id;
    private final FamilyName name;
    private final RegistrationDate registrationDate;
    private EmailAddress admin;
    private List<Relation> relations = new ArrayList<>();
    private AccountID cashAccount;

    public Family(FamilyID familyID, FamilyName familyName, RegistrationDate registrationDate, EmailAddress adminEmail) {
        this.id = familyID;
        this.name = familyName;
        this.registrationDate = registrationDate;
        this.admin = adminEmail;
    }

    @Deprecated
    public Family(UUID familyID, String familyName, LocalDate registrationDate, EmailAddress adminEmail) {
        this.id = new FamilyID(familyID);
        this.name = new FamilyName(familyName);
        this.registrationDate = new RegistrationDate(registrationDate);
        this.admin = adminEmail;
    }

    public boolean isIDofThisFamily(FamilyID familyID) { //Implementado do Agregate Root ?
        return this.id.equals(familyID);
    }

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

    public boolean isPersonTheAdmin(Person loggedUser) {
        return loggedUser.isSameEmail(this.admin);
    }
}
