package switch2020.project.utils;

import switch2020.project.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberProfileDTO {
    private String name;
    private Date birthDate;
    private List<PhoneNumber> phoneNumbers = new ArrayList();
    private List<EmailAddress> emails = new ArrayList<>();
    private VatNumber vatNumber;
    private Address address;
    private Relation relation;
    private boolean administrator;


    public MemberProfileDTO(String name, Date birthDate, List<PhoneNumber> phoneNumbers, List<EmailAddress> emails, VatNumber vatNumber, Address address, Relation relation, boolean administrator) {
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.vatNumber = vatNumber;
        this.address = address;
        this.relation = relation;
        this.administrator = administrator;
    }
}
