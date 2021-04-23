package switchtwentytwenty.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices.AddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices.CreateFamilyService;


@SpringBootApplication
public class
FFMSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FFMSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CreateFamilyService createFamilyService) {
        return (args) -> {
            InputPersonDTO inputPersonDTO = new InputPersonDTO("tonyze@latinlover.com", "tonyze@latinlover.com", "TonyZe", "12/12/1999", 999999999, 919999999, "Rua do Charme", "Cidade do Encanto", "69", "1234-123");
            InputFamilyDTO inputFamilyDTO = new InputFamilyDTO("Antunes", "22/01/2021");
            InputPersonDTO inputPersonDTO2 = new InputPersonDTO("fuzileiro_gostoso@gmail.com", "fuzileiro_gostoso@gmail.com", "Ricardo", "20/4/1989", 888888888, 911111111, "Rua da Amargura", "Porto", "420", "4321-321");
            InputFamilyDTO inputFamilyDTO2 = new InputFamilyDTO("Batista", null);
            InputFamilyDTO inputFamilyDTO3 = new InputFamilyDTO("Baggins", "3/1/1892");
            InputPersonDTO inputPersonDTO3 = new InputPersonDTO("samslittlestud@wraithmail.me", "samslittlestud@wraithmail.me", "Frodo", "29/6/1954", 123456789, null, "Bag End", "Shire", "333", "4321-321");

            //InputPersonDTO inputPersonDTOduplicate = new InputPersonDTO("fuzileiro_gostoso@gmail.com", "fuzileiro_gostoso@gmail.com", "Ricardo", "20/4/1989", 888888888, 911111111, "Rua da Amargura", "Porto", "420", "4321-321");
            //createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTOduplicate);

            createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO2, inputPersonDTO2);
            createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO);
            createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO3, inputPersonDTO3);



        };
    }

}