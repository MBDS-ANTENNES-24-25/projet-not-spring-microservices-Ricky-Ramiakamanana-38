package fr.itu.mbds.competence;

import fr.itu.mbds.competence.entity.Competence;
import fr.itu.mbds.competence.repository.CompetenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompetenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetenceApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CompetenceRepository competenceRepository) {
        return args -> {
            if (competenceRepository.count() == 0) {
                competenceRepository.save(new Competence(null, "Java"));
                competenceRepository.save(new Competence(null, "Spring Boot"));
                competenceRepository.save(new Competence(null, "Docker"));
                competenceRepository.save(new Competence(null, "Kubernetes"));
                competenceRepository.save(new Competence(null, "Angular"));
                competenceRepository.save(new Competence(null, "React"));
                System.out.println("Compétences initialisées avec succès !");
            }
        };
    }
}
