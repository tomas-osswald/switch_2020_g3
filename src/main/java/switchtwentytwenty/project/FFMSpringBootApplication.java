package switchtwentytwenty.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.person.AddFamilyMemberDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IAccountRESTController;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IFamilyRESTController;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;

import java.math.BigDecimal;


@SpringBootApplication
public class
FFMSpringBootApplication {
    private String TONYZEEMAIL = "tonyze@latinlover.com";
    private String KATIAVANESSAEMIAL = "kvanessa@latina.com";

    public static void main(String[] args) {
        SpringApplication.run(FFMSpringBootApplication.class, args);
    }

    @Bean

    public CommandLineRunner demo(IFamilyRESTController familyRESTController, IPersonRESTController personRESTController, IAccountRESTController iAccountRESTController) {
        return args -> {

            AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO1 = new AddFamilyAndSetAdminDTO(TONYZEEMAIL, "TonyZe", "12/12/1969", 123456789, 919999999, "Rua do Charme", "Cidade do Zexo", "69 Esquerdo", "1234-123", "Antunes", null);
            AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO2 = new AddFamilyAndSetAdminDTO("rifens@ravens.com", "Rifens", "05/05/1920", 987654321, 911111111, "Rua do Sertin", "Zelmin", "223", "1112-111", "Ravens", "01/01/2021");
            AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO(TONYZEEMAIL, KATIAVANESSAEMIAL, "Katia Vanessa", "20/01/1970", 777777777, 921232323, "Rua do Charme", "Cidade do Zexo", "69 Esquerdo", "1234-123");
            CreateAccountDTO vanessaAccount = new CreateAccountDTO("Conta para fugir do TonyZe", BigDecimal.valueOf(1034.54), "EUR", KATIAVANESSAEMIAL, "bank");
            CreateAccountDTO tonyaccount = new CreateAccountDTO("Lavagem de dinheiro", BigDecimal.valueOf(12.3), "EUR", TONYZEEMAIL, "cash");

            familyRESTController.createFamilyAndSetAdmin(addFamilyAndSetAdminDTO1);
            familyRESTController.createFamilyAndSetAdmin(addFamilyAndSetAdminDTO2);
            personRESTController.addFamilyMember(addFamilyMemberDTO);
            personRESTController.addEmail(new AddEmailDTO("KvanessaBackup@yahoo.com"), KATIAVANESSAEMIAL);
            iAccountRESTController.createAccount(vanessaAccount);
            iAccountRESTController.createAccount(tonyaccount);
        };
    }

}