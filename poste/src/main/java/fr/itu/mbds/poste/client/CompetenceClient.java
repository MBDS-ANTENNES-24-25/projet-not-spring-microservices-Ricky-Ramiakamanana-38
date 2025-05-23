package fr.itu.mbds.poste.client;

import fr.itu.mbds.poste.model.Competence;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "competence", url = "http://localhost:8080")
public interface CompetenceClient {
    @GetMapping("/skills")
    List<Competence> getAllCompetences();

    @GetMapping("/skill/{id}")
    Competence getCompetenceById(@PathVariable Long id);
}
