package switchtwentytwenty.project.domain.model;

import switchtwentytwenty.project.domain.services.*;

public class Application {

    // Attributes

    private EmailService emailService = new EmailService();
    private CategoryService categoryService = new CategoryService();
    private FamilyService familyService = new FamilyService();
    private AccountService accountService = new AccountService();
    private RelationService relationService = new RelationService();

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
        return this.emailService;
    }

    public RelationService getRelationService() {
        return this.relationService;
    }
}
