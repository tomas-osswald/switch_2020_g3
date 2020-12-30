package switch2020.project.model;


public class FamilyMember {

    private int personID;
    private String name;
    private String birthDate;
    private PhoneNumber phoneNumber;
    private EmailAddress email;
    private VatNumber vatNumber;
    private int admin;

    public FamilyMember(String name, String birthDate, PhoneNumber phone, EmailAddress email, VatNumber vat, int admin){
        if(!checkBirthDate(birthDate))
            throw new IllegalArgumentException("Invalid Date");
        this.birthDate = birthDate;

        if(!checkName(name))
            throw new IllegalArgumentException();
        this.phoneNumber = phone;
        this.email = email;
        this.vatNumber = vat;
    }

    private boolean checkBirthDate(String birthDate){
        if (birthDate == null)
            return false;
    }

    private boolean checkName(String name){
        if (name==null)
            return false;
    }

}
