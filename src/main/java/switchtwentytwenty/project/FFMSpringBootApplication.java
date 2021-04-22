package switchtwentytwenty.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import switchtwentytwenty.project.dto.AddPersonFormDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;
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

            CreateFamilyDTO createFamilyDTO = new CreateFamilyDTO("Silva", "22/04/2021");
            AddPersonFormDTO addPersonFormDTO = new AddPersonFormDTO(null, "tonyze@latinlover.com", "TonyZe", "20/4/1989", 999999999, 919888888, "Rua da Amargura", "Porto", "2º Esq", "4500-450");
            CreateFamilyDTO createFamilyDTO2 = new CreateFamilyDTO("Vagrrant", "22/04/2021");
            AddPersonFormDTO addPersonFormDTO2 = new AddPersonFormDTO(null, "jeanpierre@baguette.com", "Jean-Pierre", "28/12/1990", 111111111, 932222222, "Croissant Street", "Lisbonne", "233", "1234-123");

            createFamilyService.createFamilyAndAddAdmin(createFamilyDTO, addPersonFormDTO);
            createFamilyService.createFamilyAndAddAdmin(createFamilyDTO2, addPersonFormDTO2);
        };
    }

}