package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.util.List;

public class BankSavingsAccount implements Account {


    private final AccountType accountType = new AccountType(AccountTypeEnum.BANKSAVINGSACCOUNT);
    // Attributes
    private AccountData accountData;
    private double interestRate;


    // Constructors
    public BankSavingsAccount(int accountID, String name, Double balance, Double interestRate) {
        try {
            if (!validateBalance(balance)) {
                balance = 0.00;
            }
            this.accountData = new AccountData(balance, name, accountID);
        } catch (InvalidAccountDesignationException exception) {
            String defaultDesignation = "Bank Savings Account with ID" + " " + accountID;
            this.accountData = new AccountData(balance, defaultDesignation, accountID);
        }

        if (!validateInterestRate(interestRate)) {
            interestRate = 0.00;
        }
        this.interestRate = interestRate;
    }


    // Business Methods

    private boolean validateBalance(Double balance) {
        boolean valid = true;
        if (balance == null) {
            valid = false;
        }
        return valid;
    }

    private boolean validateInterestRate(Double interestRate) {
        boolean valid = true;
        if (interestRate == null) {
            valid = false;
        }
        return valid;
    }

    public int getAccountID() {
        return this.accountData.getAccountID();
    }

    //TODO: Destruir (inclui Interface)
    public double getBalance() {
    return 99999999;
    }

    /*
    private double calculateInterest() {
        double balance = this.accountData.getBalance();
        long interestDays = calculateDaysBetweenNowAndADate(this.accountData.getCreationDate());
        for (int i = 0; i < interestDays; i++) {
            balance = balance * this.interestRate;
        }
        return balance;
    }

    private long calculateDaysBetweenNowAndADate(Date date) {
        Date currentDate = new Date();
        LocalDateTime now = LocalDateTime.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDay(), currentDate.getHours(), currentDate.getMinutes());
        LocalDateTime dateToCheck = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), date.getHours(), date.getMinutes());
        return Duration.between(now, dateToCheck).toDays();
    }
*/


    //TODO: Destruir (inclui Interface)
    public void changeBalance(double value) {
            }

    public void changeBalance(MoneyValue value) {
        this.accountData.changeBalance(value.getValue());
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public AccountData getAccountData() {
        return accountData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankSavingsAccount that = (BankSavingsAccount) o;
        return Double.compare(that.interestRate, interestRate) == 0 && accountData.equals(that.accountData);
    }

    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    /**
     * A method that always returns true, because there has no restrictions for this account type
     *
     * @param value
     * @return
     */

    public boolean hasEnoughMoneyForTransaction(MoneyValue value) {
        return true;
    }

    public boolean registerTransaction(Account targetAccount, Category category, FamilyCashTransferDTO familyCashTransferDTO) {
        return accountData.registerTransaction(targetAccount, category, familyCashTransferDTO);
    }

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum) {
        return this.accountType.getAccountType().equals(accountTypeEnum);
    }

    public String getDescription() {
        return accountData.getDescription();
    }

    public MoneyValue getMoneyBalance() {
        return this.accountData.getCurrentBalance();
    }

    /**
     * A method that returns the list of movements stored in this account's AccountData attribute
     *
     * @return List of movements
     */
    public List<Transaction> getListOfMovements() {
        return this.accountData.getListOfMovements();
    }

    public void debit(MoneyValue value) {
    this.accountData.setBalance(this.accountData.getMoneyValue().debit(value));
    }

    public void credit(MoneyValue value) {
    this.accountData.setBalance(this.accountData.getMoneyValue().credit(value));
    }
}