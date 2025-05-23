package fr.itu.mbds.poste.client;

import fr.itu.mbds.poste.model.Competence;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COMPETENCE")
public interface CompetenceClient {
    @GetMapping("/skills")
    @CircuitBreaker(name = "competence", fallbackMethod = "fallbackGetAllCompetences")
    List<Competence> getAllCompetences();

    @GetMapping("/skill/{id}")
    @CircuitBreaker(name = "competence", fallbackMethod = "fallbackGetCompetenceById")
    Competence getCompetenceById(@PathVariable Long id);

    default List<Competence> fallbackGetAllCompetences(Exception e) {
        return List.of();
    }

    default Competence fallbackGetCompetenceById(Long id, Exception e) {
        Competence competence = new Competence();
        competence.setId(id);
        competence.setNom("Not available");
        return competence;
    }
}
