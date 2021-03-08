package switchtwentytwenty.project.domain.model;

import switchtwentytwenty.project.domain.services.*;

public class Application {

    // Attributes

    private final CategoryService categoryService = new CategoryService();
    private final FamilyService familyService = new FamilyService();
    private final AccountService accountService = new AccountService(this.familyService);


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
        return new RelationService();
    }

    public TransactionService getTransactionService() {
        return new TransactionService();
    }

}
