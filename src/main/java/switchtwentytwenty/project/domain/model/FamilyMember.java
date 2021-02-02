package switchtwentytwenty.project.domain.model;

import switchtwentytwenty.project.domain.dtos.output.MemberProfileDTO;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.user_data.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class FamilyMember {

    // Attributes
    private CCNumber ccNumber;
    private String name;
    private Date birthDate;
    private List<PhoneNumber> phoneNumbers = new ArrayList();
    private List<EmailAddress> emails = new ArrayList<>();
    private VatNumber vatNumber;
    private Address address;
    private boolean administrator;
    private List<Account> accounts = new ArrayList<>();


    /********************** CONSTRUCTORS **********************/

    //Constructor that uses a CCNumber as ID
    public FamilyMember(String ccNumber, String name, Date birthDate, Integer phone, String email, int vat, String street, String codPostal, String local, String city, boolean administrator) {

        this.ccNumber = new CCNumber(ccNumber);

        if (!validateName(name)) {
            throw new IllegalArgumentException("Invalid Name");
        }
        this.name = name;

        if (!validateBirthDate(birthDate)) {
            throw new IllegalArgumentException("Insert Date");
        }
        this.birthDate = (Date) birthDate.clone();

        PhoneNumber telef = new PhoneNumber(phone);
        this.phoneNumbers.add(telef);

        EmailAddress mail = new EmailAddress(email);
        this.emails.add(mail);

        VatNumber nif = new VatNumber(vat);
        this.vatNumber = nif;

        Address morada = new Address(street, codPostal, local, city);
        this.address = morada;

        this.administrator = administrator;
    }

    public FamilyMember(String ccNumber, String name, Date birthDate, Integer phone, String email, int vat, String street, String codPostal, String local, String city) {

        this.ccNumber = new CCNumber(ccNumber);

        if (!validateName(name)) {
            throw new IllegalArgumentException("Invalid Name");
        }
        this.name = name;

        if (!validateBirthDate(birthDate)) {
            throw new IllegalArgumentException("Insert Date");
        }
        this.birthDate = (Date) birthDate.clone();

        if (validatePhone(phone)) {
            PhoneNumber telef = new PhoneNumber(phone);
            this.phoneNumbers.add(telef);
        }

        if (validateEmail(email)) {
            EmailAddress mail = new EmailAddress(email);
            this.emails.add(mail);
        }

        VatNumber nif = new VatNumber(vat);
        this.vatNumber = nif;

        Address morada = new Address(street, codPostal, local, city);
        this.address = morada;
    }


    /********************** GETTERS AND SETTERS **********************/

    public boolean validateName(String name) {
        return (!(name == null || name.isEmpty() || name.trim().length() == 0));
    }

    private boolean validateBirthDate(Date birthDate) {
        return (!(birthDate == null || birthDate.toString().isEmpty()));
    }

    public boolean validateEmail(String email) {
        return (!(email == null || email.isEmpty() || email.trim().length() == 0));
    }

    public boolean validatePhone(Integer phone) {
        return (!(phone == null));
    }

    public List<EmailAddress> getEmails() {
        return Collections.unmodifiableList(emails);
    }


    public int getVatNumber() {
        return this.vatNumber.getVatNumber();
    }

    /**
     * @return String representing the FamilyMember's ID.
     */
    public String getID() {
        return this.ccNumber.getCcNumber();
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

    public boolean isAdministrator() {
        return this.administrator;
    }

    /********************** USER STORIES **********************/

    /**
     * Method to get a FamilyMember his ID
     *
     * @return Family Member ID
     */

    // Importado do Head
    protected String getFamilyMemberID() {
        return this.ccNumber.getCcNumber();
    }

    /**
     * Method to create an EmailAddress object and add it to the ArrayList of EmailAddress objects
     *
     * @param emailToAdd String of the email address to add
     * @return True if the EmailAddress object is successfully created and added to the EmailAddress ArrayList
     */
    public boolean addEmail(String emailToAdd) {
        try{
            EmailAddress newEmail = new EmailAddress(emailToAdd);
            emails.add(newEmail);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }

    }


    /**
     * method that uses the attributes from the family member
     * to create and return a MemberProfileDTO
     *
     * @return MemberProfileDTO with member's attributes
     */
    public MemberProfileDTO createProfile() {
        return new MemberProfileDTO(ccNumber, name, birthDate, phoneNumbers, emails, vatNumber, address, administrator);
    }


    public List<Account> getAccounts() {
        List<Account> accountsClone = this.accounts;
        return accountsClone;
    }

    protected boolean compareID(String ccNumber) {
        return ccNumber.equalsIgnoreCase(this.ccNumber.getCcNumber());
    }

    // Adicionar este metodo ao addAccount() -> verificar se sao o mesmo tipo de Conta e se o IBAN é igual
    /*
    public boolean checkIfAccountAlreadyPresent(Account account){
        for (Account accountTest : this.accounts) {
            if( account.getIban() == accountTest.getIban() && account.getClass() == accountTest.getClass());
                return true;
        }
        return false;
    }
     */

    public boolean addAccount(Account account) {
        if (account == null) {
            return false;
        }
        return this.accounts.add(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof FamilyMember)) return false;

        FamilyMember otherMember = (FamilyMember) o;

        return (this.ccNumber.equals(otherMember.ccNumber) && this.administrator == otherMember.administrator && this.accounts.equals(otherMember.accounts) && this.name.equals(otherMember.name) && this.birthDate.equals(otherMember.birthDate) && this.phoneNumbers.equals(otherMember.phoneNumbers) && this.emails.equals(otherMember.emails) && this.vatNumber.equals(otherMember.vatNumber) && this.address.equals(otherMember.address));
    }

    public Account getAccount(int accountID) {
        for (Account account : accounts) {
            if (account.isIDOfThisAccount(accountID)) return account;
        }
        return null;
    }

}



