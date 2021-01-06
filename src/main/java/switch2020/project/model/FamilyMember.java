package main.java.switch2020.project.model;

import java.util.ArrayList;

public class FamilyMember {

    private int familyMemberID;
    private String name;
    private String birthDate;
    private ArrayList<PhoneNumber> phoneNumbers = new ArrayList();
    private ArrayList<EmailAddress> emails = new ArrayList();
    private VatNumber vatNumber;
    private Address address;
    private Relationship relationship;
    private boolean administrator;

    /********************** CONSTRUCTORS **********************/

    // System Manager - add FamilyMember
    public FamilyMember(String name, String birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relationship relationship, boolean administrator){
        if(!validateBirthDate(name))
            throw new IllegalArgumentException();
        this.name = name;

        if(!validateBirthDate(birthDate))
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

        this.relationship = relationship;

        this.administrator = administrator;
    }

    // Family Admin - add Family Member
    public FamilyMember(String name, String birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relationship relationship){
        if(!validateName(name))
            throw new IllegalArgumentException();
        this.name = name;

        if(!validateBirthDate(birthDate))
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

        this.relationship = relationship;

        this.administrator = false;
    }

    // Add email to FamilyMember
    public FamilyMember(int iD) {
        this.familyMemberID = iD;
    }

    /********************** GETTERS AND SETTERS **********************/

    private boolean validateName(String name){
        if (name == null);
        return false;
    }

    private boolean validateBirthDate(String birthDate){
        if (birthDate == null);
            return false;
    }

    private boolean validateRelation(Relationship relation) {
        if (relation == null);
            return false;
    }

    /*********************************/

    public ArrayList<EmailAddress> getEmails() {
        return emails;
    }

    public Integer getVatNumber() {
        return this.vatNumber.getVatNumber();
    }

    /**
     * @return Int representing the FamilyMember's ID.
     */
    public int getID() { return this.familyMemberID; }

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



}



