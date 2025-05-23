package fr.itu.mbds.competence.controller;

import fr.itu.mbds.competence.dto.CompetenceDTO;
import fr.itu.mbds.competence.service.CompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @GetMapping("/skills")
    public List<CompetenceDTO> getAllCompetences() {
        return competenceService.findAll();
    }

    @GetMapping("/skill/{id}")
    public CompetenceDTO getCompetenceById(@PathVariable Long id) {
        return competenceService.findById(id);
    }
}
