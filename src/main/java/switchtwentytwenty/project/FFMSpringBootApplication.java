package switchtwentytwenty.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
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
            InputPersonDTO inputPersonDTO = new InputPersonDTO("tonyze@gmail.com","tonyze@gmail.com","TonyZe","12/12/1999",999999999,919999999,"Rua","Cidade", "69","1234-123");
            InputFamilyDTO inputFamilyDTO = new InputFamilyDTO("Antunes","22/01/2021");
            InputPersonDTO inputPersonDTO2 = new InputPersonDTO("fuzileiro_gostoso@gmail.com","fuzileiro_gostoso@gmail.com","Ricardo","20/4/1989",888888888,911111111,"Rua da Amargura","Porto", "420","4321-321");
            InputFamilyDTO inputFamilyDTO2 = new InputFamilyDTO("Batista",null);
            createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO,inputPersonDTO);
            createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO2,inputPersonDTO2);



        };
    }

}