package switch2020.project.model;

import java.util.ArrayList;
import java.util.Date;

public class FamilyMember {

    // Attributes
    private int familyMemberID;
    private String name;
    private String birthDate;
    private ArrayList<PhoneNumber> phoneNumbers = new ArrayList();
    private ArrayList<EmailAddress> emails = new ArrayList();
    private VatNumber vatNumber;
    private Address address;
    private Relation relation;
    private boolean administrator;

    /********************** CONSTRUCTORS **********************/

    // System Manager - add FamilyMember
    public FamilyMember(int familyMemberID, String name, String birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city, Relation relation, boolean administrator) {

        this.familyMemberID = familyMemberID;

        if (!validateName(name))
            throw new IllegalArgumentException();
        this.name = name;

        if (!validateBirthDate(birthDate))
            throw new IllegalArgumentException("Invalid Date");
        this.birthDate = birthDate;

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
        this.birthDate = birthDate;

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
        this.birthDate = birthDate;

        PhoneNumber telef = new PhoneNumber(phone);
        this.phoneNumbers.add(telef);

        EmailAddress mail = new EmailAddress(email);
        this.emails.add(mail);

        VatNumber nif = new VatNumber(vat);
        this.vatNumber = nif;

        Address morada = new Address(street, codPostal, local, city);
        this.address = morada;

        this.administrator = false;
    }

    // Add email to FamilyMember
    public FamilyMember(String name, String birthDate, int iD, String email, int vat, String street, String codPostal, String local, String city, Relation relation) {
        this.familyMemberID = iD;
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

    private boolean validateRelation(Relation relation) {
        if (this.relation != null)
            return true;
        return false;
    }

    /*********************************/

    public ArrayList<EmailAddress> getEmails() {
        return emails;
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
    public String getRelation(){
        return relation.getRelationDesignation();
    }

    public String getName() {
        return name;
    }

    public FamilyMember(int familyMemberID) {
        this.familyMemberID = familyMemberID;
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



