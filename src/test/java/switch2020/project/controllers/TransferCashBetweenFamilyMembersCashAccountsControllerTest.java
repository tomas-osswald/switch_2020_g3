package switch2020.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switch2020.project.domain.DTOs.input.AddCreditCardAccountDTO;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

import static org.junit.jupiter.api.Assertions.*;

class TransferCashBetweenFamilyMembersCashAccountsControllerTest {

    Application app = new Application();
    FamilyService familyService = app.getFamilyService();
    AccountService accountService = app.getAccountService();

    TransferCashBetweenFamilyMembersCashAccountsController transferMoneyController = new TransferCashBetweenFamilyMembersCashAccountsController(app);

    @Test
    void transferCashBetweenFamilyMemberWithSuficientCashToOtherFamilyMember() {

    }

    @Test
    void transferCashBetweenFamilyMemberWithInsuficientCashToOtherFamilyMember() {

    }

}

