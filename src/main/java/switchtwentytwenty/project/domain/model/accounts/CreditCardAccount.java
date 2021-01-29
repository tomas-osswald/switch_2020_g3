package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;
import switchtwentytwenty.project.domain.DTOs.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

public class CreditCardAccount implements Account {

    // Attributes
    private AccountData accountData;
    private MoneyValue withdrawalLimit;
    private MoneyValue interestDebt;
    private final AccountType accountType = new AccountType(AccountTypeEnum.CREDITCARDACCOUNT);

    // Constructors
    public CreditCardAccount(AddCreditCardAccountDTO addCreditCardAccountDTO, int accountID) {
        validadeWithrawLimit(addCreditCardAccountDTO.getWithdrwaLimit());
        try {
            this.accountData = new AccountData(addCreditCardAccountDTO.getTotalDebt(), addCreditCardAccountDTO.getCardDescription(), accountID);
        } catch (InvalidAccountDesignationException exception) {
            String cardDescriptionDefault = "Credit Card Account " + "-" + " Account #" + accountID;
            this.accountData = new AccountData(addCreditCardAccountDTO.getTotalDebt(), cardDescriptionDefault, accountID);
        }
        this.withdrawalLimit = new MoneyValue(addCreditCardAccountDTO.getWithdrwaLimit(), addCreditCardAccountDTO.getCurrency());

        this.interestDebt = new MoneyValue(addCreditCardAccountDTO.getInterestDebt(), addCreditCardAccountDTO.getCurrency());
    }

    // Bussiness Methods

    public MoneyValue getInterestDebt () {
        return this.interestDebt;
    }

    /**
     *
     * @param withdrawalLimit
     */

    private void validadeWithrawLimit(double withdrawalLimit) {
        if (!validateWithrawalLimit(withdrawalLimit)) {
            throw new IllegalArgumentException("withdrawal limit can't be less than 0");
        }
    }
    /**
     * @param withrawalLimit
     * @return
     */

    private boolean validateWithrawalLimit(Double withrawalLimit) {
        if (withrawalLimit == null)
            return false;
        return withrawalLimit > 0.00;
    }

    /**
     * Getter for the ID of this cash account object
     *
     * @return returns the ID of this cash account
     */
    public int getAccountID() {
        return
                this.accountData.getAccountID();
    }

    /**
     * Getter for the balance of this cash account object
     *
     * @return returns the balance of this cash account
     */
    public double getBalance() {
        return this.accountData.getBalance();
    }

    /*public double getWithdrawalLimit() {
        return withdrawalLimit;
    }*/

    public void changeBalance(MoneyValue value) { //expense
        // validar se mesma moeda
        //TODO: isto vai ser preciso validar? ou cagar e andar? ass: johnny sins
        if ((this.accountData.getMoneyValue().credit(value).compareTo(withdrawalLimit) < 0.00))
            throw new IllegalArgumentException("ultrapassa credito");

        this.accountData.setBalance(this.accountData.getMoneyValue().credit(value));
    }

    public void changeBalance(double value) { //expense
        // validar se mesma moeda
        if (true/*(this.accountData.getBalance() - Math.abs(value)) > withdrawalLimit*/)
            throw new IllegalArgumentException("ultrapassa credito");
        this.accountData.setBalance(this.accountData.getBalance() - Math.abs(value));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CreditCardAccount)) return false;
        CreditCardAccount otherAccount = (CreditCardAccount) other;
        return this.accountData.equals(otherAccount.accountData);
    }

    public String getDescription() {
        return this.accountData.getDescription();
    }

    public boolean isIDOfThisAccount(int accountID){
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(double transferenceAmount ){
        return accountData.hasEnoughMoneyForTransaction(transferenceAmount);
        //TODO: Discutir na reunião se faz sentido estar em todas as contas ass:johnny sins
    }
    public boolean registerTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO){
        return accountData.registerTransaction(targetAccount, category, transferenceDTO);
    }

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum){
        return this.accountType.getAccountType().equals(accountTypeEnum);
    }

    public MoneyValue getMoneyBalance() {
        return this.accountData.getCurrentBalance();
    }
}
