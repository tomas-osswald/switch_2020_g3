package switch2020.project.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;


public class FamilyMember {

    // Attributes
    private int familyMemberID;
    private String name;
    private Date birthDate;
    private List<PhoneNumber> phoneNumbers = new ArrayList();
    private List<EmailAddress> emails = new ArrayList<>();
    private VatNumber vatNumber;
    private Address address;
    private Relation relation;
    private boolean administrator;

    /********************** CONSTRUCTORS **********************/

    // System Manager - add FamilyMember
    public FamilyMember(int familyMemberID, String name, String birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city, Relation relation, boolean administrator) {

        this.familyMemberID = familyMemberID;

        if (!validateName(name))
            throw new IllegalArgumentException("Invalid Name");
        this.name = name;

        if (!validateBirthDate(birthDate))
            throw new IllegalArgumentException("Invalid Date. Correct format: dd/mm/yyyy");
        this.birthDate = validateFormatDate(birthDate);

        PhoneNumber telef = new PhoneNumber(phone);
        this.phoneNumbers.add(telef);

        EmailAddress mail = new EmailAddress(email);
        this.emails.add(mail);

        VatNumber nif = new VatNumber(vat);
        this.vatNumber = nif;

        Address morada = new Address(street, codPostal, local, city);
        this.address = morada;

        this.relation = relation;

        this.administrator = administrator;
    }

    // Family Admin - add Family Member
    public FamilyMember(int familyMemberID, String name, String birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city, Relation relation) {

        this.familyMemberID = familyMemberID;

        if (!validateName(name))
            throw new IllegalArgumentException();
        this.name = name;

        if (!validateBirthDate(birthDate))
            throw new IllegalArgumentException("Invalid Date");
        this.birthDate = validateFormatDate(birthDate);

        PhoneNumber telef = new PhoneNumber(phone);
        this.phoneNumbers.add(telef);

        EmailAddress mail = new EmailAddress(email);
        this.emails.add(mail);

        VatNumber nif = new VatNumber(vat);
        this.vatNumber = nif;

        Address morada = new Address(street, codPostal, local, city);
        this.address = morada;

        this.relation = relation;

        this.administrator = false;
    }

    //Constructor without relation
    public FamilyMember(int familyMemberID, String name, String birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city) {

        this.familyMemberID = familyMemberID;

        if (!validateName(name))
            throw new IllegalArgumentException();
        this.name = name;

        if (!validateBirthDate(birthDate))
            throw new IllegalArgumentException("Invalid Date");
        this.birthDate = validateFormatDate(birthDate);

        PhoneNumber telef = new PhoneNumber(phone);
        this.phoneNumbers.add(telef);

        EmailAddress mail = new EmailAddress(email);
        this.emails.add(mail);

        VatNumber nif = new VatNumber(vat);
        this.vatNumber = nif;

        Address morada = new Address(street, codPostal, local, city);
        this.address = morada;

        this.relation = new Relation(null);

        this.administrator = false;
    }

    // Add email to FamilyMember
    public FamilyMember(String name, String birthDate, int iD, String email, int vat, String street, String codPostal, String local, String city, Relation relation) {
        this.familyMemberID = iD;
    }

    public FamilyMember(int familyMemberID) {
        this.familyMemberID = familyMemberID;
    }

    /********************** GETTERS AND SETTERS **********************/

    private boolean validateName(String name) {
        if (name != null)
            return true;
        return false;
    }

    private boolean validateBirthDate(String birthDate) {
        if (birthDate != null)
            return true;
        return false;
    }

    private Date validateFormatDate(String birthDate){
        Date data = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setLenient(false);
        try{
            data = sdf.parse(birthDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid Date. Correct format: dd/mm/yyyy");
        }
        return data;
    }

    private boolean validateRelation(Relation relation) {
        if (this.relation != null)
            return true;
        return false;
    }

    public List<EmailAddress> getEmails() {
        return Collections.unmodifiableList(emails);
    }

    public int getVatNumber() {
        return this.vatNumber.getVatNumber();
    }

    /**
     * @return Int representing the FamilyMember's ID.
     */
    public int getID() {
        return this.familyMemberID;
    }

    // Business Methods
    public String getRelation() {
        return relation.getRelationDesignation();
    }

    public String getName() {
        return name;
    }

    /**
     * Method to make a familyMember Administrator
     */

    public void makeAdmin() {
        this.administrator = true;
    }

    /**
     * Method to verify if a given Family Member is Administrator
     *
     * @return boolean
     */

    public boolean isAdmin() {
        return this.administrator;
    }

    /**
     * Method to get a FamilyMember his ID
     *
     * @return Family Member ID
     */

    // Importado do Head
    protected int getFamilyMemberID() {
        return this.familyMemberID;
    }

    /********************** USER STORIES **********************/


    /**
     * Method to create an EmailAddress object and add it to the ArrayList of EmailAddress objects
     *
     * @param emailToAdd String of the email address to add
     * @return True if the EmailAddress object is successfully created and added to the EmailAddress ArrayList
     */
    public boolean addEmail(String emailToAdd) {
        EmailAddress newEmail = new EmailAddress(emailToAdd);
        emails.add(newEmail);
        return true;
    }

    /**
     * Method to add a Relation to Family Member
     *
     * @param relation Relation to add
     */

    protected void addRelation(Relation relation) {
        if (this.relation != null)
            throw new IllegalArgumentException("This family member already has an assigned relation");
        this.relation = relation;
    }

}



