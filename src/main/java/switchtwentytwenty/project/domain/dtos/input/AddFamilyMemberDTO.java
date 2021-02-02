package switchtwentytwenty.project.domain.dtos.input;

import java.util.Date;

public class AddFamilyMemberDTO {

    private final String selfCCNumber;
    private final String cc;
    private final String name;
    private final Date birthDate;
    private final Integer phone;
    private final String email;
    private final Integer vat;
    private final String street;
    private final String codPostal;
    private final String local;
    private final String city;
    private final int familyID;

    public AddFamilyMemberDTO(String selfCCNumber,String cc, String name, Date birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, int familyID){
        this.selfCCNumber = selfCCNumber;
        this.cc = cc;
        this.name = name;
        if (birthDate == null ){
            this.birthDate = new Date();
        } else {
            this.birthDate = (Date) birthDate.clone();
        }
        this.phone = phone;
        this.email = email;
        this.vat = vat;
        this.street = street;
        this.codPostal = codPostal;
        this.local = local;
        this.city = city;
        this.familyID = familyID;
    }

    public String getSelfCCNumber(){ return this.selfCCNumber;}

    public String getCc(){return this.cc;}

    public String getName(){ return this.name; }

    public Date getBirthDate() { return (Date) this.birthDate.clone(); }

    public Integer getPhone() { return this.phone; }

    public String getEmail() { return this.email; }

    public Integer getVat() { return this.vat; }

    public String getStreet() { return this.street; }

    public String getCodPostal() { return this.codPostal; }

    public String getLocal() { return this.local; }

    public String getCity() { return this.city; }

    public int getFamilyID() { return this.familyID; }

}
