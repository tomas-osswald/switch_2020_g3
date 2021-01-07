package switch2020.project.model;

public class MemberProfile {
    private String email;
    private String name;
    private String birthDate;
    private int phone;
    private int vatNumber;

    public MemberProfile(String email, String name, String birthDate, int phone, int vatNumber) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.vatNumber = vatNumber;
    }
}
