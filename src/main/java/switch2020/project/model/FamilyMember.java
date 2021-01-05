package main.java.switch2020.project.model;


public class FamilyMember {

    private int personID;
    private String name;
    private String birthDate;
    private PhoneNumber phoneNumber;
    private EmailAddress email;
    private VatNumber vatNumber;
    private Relationship relationship;
    private boolean isAdmin;

    // System Manager
    public FamilyMember(String name, String birthDate, PhoneNumber phone, EmailAddress email, VatNumber vat, Relationship relationship, boolean isAdmin){
        if(!validate(name))
            throw new IllegalArgumentException();
        this.name = name;

        if(!validate(birthDate))
            throw new IllegalArgumentException("Invalid Date");
        this.birthDate = birthDate;

        if(!validatePhone(phone))
            throw new IllegalArgumentException("Invalid Phone");
        this.phoneNumber = phone;

        if(!validateEmail(email))
            throw new IllegalArgumentException("Invalid Email");
        this.email = email;

        if(!validateVat(vat))
            throw new IllegalArgumentException("Invalid VatNumber");
        this.vatNumber = vat;

        if(!validateRelation(relationship))
            throw new IllegalArgumentException("Invalid Relationship");
        this.relationship = relationship;

        this.isAdmin = isAdmin;
    }

    // Family Admin
    public FamilyMember(String name, String birthDate, PhoneNumber phone, EmailAddress email, VatNumber vat, Relationship relationship){
        if(!validate(name))
            throw new IllegalArgumentException();
        this.name = name;

        if(!validate(birthDate))
            throw new IllegalArgumentException("Invalid Date");
        this.birthDate = birthDate;

        if(!validatePhone(phone))
            throw new IllegalArgumentException("Invalid Phone");
        this.phoneNumber = phone;

        if(!validateEmail(email))
            throw new IllegalArgumentException("Invalid Email");
        this.email = email;

        if(!validateVat(vat))
            throw new IllegalArgumentException("Invalid VatNumber");
        this.vatNumber = vat;

        if(!validateRelation(relationship))
            throw new IllegalArgumentException("Invalid Relationship");
        this.relationship = relationship;
    }

    private boolean validate(String birthDate){
        if (birthDate == null)
            return false;
    }

    private boolean validatePhone(PhoneNumber phone){
        if (phone == null)
            return false;
    }

    private boolean validateEmail(EmailAddress email){
        if (email == null)
            return false;
    }

    private boolean validateVat(VatNumber vat){
        if (vat == null)
            return false;
    }

    private boolean validateRelation(Relationship relation){
        if(relation == null)
            return false;
    }

}
