package switchtwentytwenty.project.domain.model;

import switchtwentytwenty.project.domain.services.*;

public class Application {

    // Attributes

    private final FamilyService familyService = new FamilyService();
    private final CategoryService categoryService = new CategoryService(this.familyService);
    private final RelationService relationService = new RelationService(this.familyService);
    private final AccountService accountService = new AccountService(this.familyService);
    private final TransactionService transactionService = new TransactionService(this.categoryService, this.accountService);


    // Constructors
    public Application() {
    }

    public Application(Family family) {
        this.familyService.addFamily(family);
    }

    public AccountService getAccountService() {
        return this.accountService;
    }

    /********************** GETTERS AND SETTERS **********************/
    // Business methods
    public CategoryService getCategoryService() {
        return this.categoryService;
    }

    public FamilyService getFamilyService() {
        return this.familyService;
    }

    public EmailService getEmailService() {
        return new EmailService();
    }

    public RelationService getRelationService() {
        return this.relationService;
    }

    public TransactionService getTransactionService() {
        return this.transactionService;
    }

}
