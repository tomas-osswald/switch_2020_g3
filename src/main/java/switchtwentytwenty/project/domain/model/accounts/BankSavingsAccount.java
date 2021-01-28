package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

public class BankSavingsAccount implements Account {


    // Attributes
    private AccountData accountData;
    private double interestRate;
    private final AccountType accountType = new AccountType(AccountTypeEnum.BANKSAVINGSACCOUNT);


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

    public double getBalance() {
        return this.accountData.getBalance();
    }


    public void changeBalance(double value) {
        this.accountData.changeBalance(value);
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

    public boolean isIDOfThisAccount(int accountID){
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(double transferenceAmount ){
        return accountData.hasEnoughMoneyForTransaction(transferenceAmount);
    }

    public boolean registerTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO){
        return accountData.registerTransaction(targetAccount, category, transferenceDTO);
    }

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum){
        return this.accountType.getAccountType().equals(accountTypeEnum);
    }

    public String getDescription(){
        return accountData.getDescription();
    }
}
