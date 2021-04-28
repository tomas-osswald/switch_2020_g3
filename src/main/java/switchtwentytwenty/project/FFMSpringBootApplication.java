package switchtwentytwenty.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import switchtwentytwenty.project.dto.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IFamilyRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices.AddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices.CreateFamilyService;


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
            familyRESTController.createFamilyAndSetAdmin(addFamilyAndSetAdminDTO1);



        };
    }

}