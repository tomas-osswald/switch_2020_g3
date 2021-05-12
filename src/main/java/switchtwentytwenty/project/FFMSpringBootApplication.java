package switchtwentytwenty.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.person.AddFamilyMemberDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IFamilyRESTController;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;



@SpringBootApplication
public class
FFMSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FFMSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(IFamilyRESTController familyRESTController, IPersonRESTController personRESTController) {
        return (args) -> {
            AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO1 = new AddFamilyAndSetAdminDTO("tonyze@latinlover.com","TonyZe","12/12/1969",123456789,919999999,"Rua do Charme","Cidade do Zexo","69 Esquerdo","1234-123","Antunes",null);
            AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO2 = new AddFamilyAndSetAdminDTO("rifens@ravens.com","Rifens","05/05/1920",987654321,911111111,"Rua do Sertin","Zelmin","223","1112-111","Ravens","01/01/2021");
            AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO("tonyze@latinlover.com","kvanessa@latina.com","Katia Vanessa","20/01/1970",777777777,921232323,"Rua do Charme","Cidade do Zexo","69 Esquerdo","1234-123");
            familyRESTController.createFamilyAndSetAdmin(addFamilyAndSetAdminDTO1);
            familyRESTController.createFamilyAndSetAdmin(addFamilyAndSetAdminDTO2);
            personRESTController.addFamilyMember(addFamilyMemberDTO);
            personRESTController.addEmail(new AddEmailDTO("KvanessaBackup@gmail.com"), "kvanessa@latina.com");
            personRESTController.addEmail(new AddEmailDTO("KvanessaBackup2222@gmail.com"), "kvanessa@latina.com");
        };
    }

}