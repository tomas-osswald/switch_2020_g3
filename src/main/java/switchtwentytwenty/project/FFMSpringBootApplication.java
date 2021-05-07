package switchtwentytwenty.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IFamilyRESTController;


@SpringBootApplication
public class
FFMSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FFMSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(IFamilyRESTController familyRESTController) {
        return (args) -> {
            AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO1 = new AddFamilyAndSetAdminDTO("tonyze@latinlover.com","TonyZe","12/12/1969",123456789,919999999,"Rua do Charme","Cidade do Zexo","69 Esquerdo","1234-123","Antunes",null);
            AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO2 = new AddFamilyAndSetAdminDTO("rifens@ravens.com","Rifens","05/05/1920",987654321,911111111,"Rua do Sertin","Zelmin","223","1112-111","Ravens","01/01/2021");
            familyRESTController.createFamilyAndSetAdmin(addFamilyAndSetAdminDTO1);
            familyRESTController.createFamilyAndSetAdmin(addFamilyAndSetAdminDTO2);
        };
    }

}