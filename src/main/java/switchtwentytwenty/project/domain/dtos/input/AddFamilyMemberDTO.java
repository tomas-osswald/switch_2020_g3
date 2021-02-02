package switchtwentytwenty.project.domain.dtos.input;

import java.util.Date;

public class AddFamilyMemberDTO {

    private String selfCCNumber;
    private String cc;
    private String name;
    private Date birthDate;
    private Integer phone;
    private String email;
    private Integer vat;
    private String street;
    private String codPostal;
    private String local;
    private String city;
    private int familyID;

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
