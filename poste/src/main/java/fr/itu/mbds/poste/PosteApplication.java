package fr.itu.mbds.poste;

import fr.itu.mbds.poste.entity.Poste;
import fr.itu.mbds.poste.repository.PosteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class PosteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosteApplication.class, args);
    }

    @Bean
    CommandLineRunner initPostes(PosteRepository posteRepository) {
        return args -> {
            if (posteRepository.count() == 0) {
                posteRepository.save(Poste.builder()
                        .id("CTO")
                        .nom("Chief Technical Officer")
                        .competenceIds(List.of(1L, 2L, 3L))
                        .build());

                posteRepository.save(Poste.builder()
                        .id("DEV")
                        .nom("Développeur Full Stack")
                        .competenceIds(List.of(1L, 2L, 5L, 6L))
                        .build());

                posteRepository.save(Poste.builder()
                        .id("PM")
                        .nom("Product Manager")
                        .competenceIds(List.of(3L, 4L))
                        .build());

                System.out.println("Postes initialisés avec succès !");
            }
        };
    }
}
