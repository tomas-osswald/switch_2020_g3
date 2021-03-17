package switchtwentytwenty.project.domain.dtos.output;

import switchtwentytwenty.project.domain.model.user_data.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MemberProfileDTO {

    private final String ccNumber;
    private final String name;
    private final Date birthDate;
    private final List<PhoneNumber> phoneNumbers;
    private final List<EmailAddress> emails;
    private final VatNumber vatNumber;
    private final Address address;
    private final boolean administrator;


    public MemberProfileDTO(CCNumber ccNumber, String name, Date birthDate, List<PhoneNumber> phoneNumbers, List<EmailAddress> emails, VatNumber vatNumber, Address address, boolean administrator) {
        this.ccNumber = ccNumber.getCcNumberString();
        this.name = name;
        this.birthDate = (Date) birthDate.clone();
        List<PhoneNumber> phoneNumbersClone = new ArrayList<>();
        phoneNumbersClone.addAll(phoneNumbers);
        this.phoneNumbers = phoneNumbersClone;
        List<EmailAddress> emailsCopy = new ArrayList<>();
        emailsCopy.addAll(emails);
        this.emails = emailsCopy;
        this.vatNumber = vatNumber;
        this.address = address;
        this.administrator = administrator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberProfileDTO)) return false;
        MemberProfileDTO that = (MemberProfileDTO) o;

        return ccNumber==that.ccNumber && administrator == that.administrator && name.equals(that.name) && birthDate.equals(that.birthDate) && phoneNumbers.equals(that.phoneNumbers) && emails.equals(that.emails) && vatNumber.equals(that.vatNumber) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, phoneNumbers, emails, vatNumber, address, administrator);
    }
}
