package switch2020.project.controllers;

import switch2020.project.model.Application;

public class GetStandardCategoriesTreeController {
    private Application app;

    public GetStandardCategoriesTreeController(Application app) {
        if (app == null) {
            throw new NullPointerException("App not found");
        }
        this.app = app;
    }
}
