package fr.itu.mbds.poste.controller;

import fr.itu.mbds.poste.dto.PosteDTO;
import fr.itu.mbds.poste.service.PosteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PosteController {

    private final PosteService posteService;

    public PosteController(PosteService posteService) {
        this.posteService = posteService;
    }

    @GetMapping("/postes")
    public List<PosteDTO> getPostes() {
        return posteService.findAll();
    }

    @GetMapping("/poste/{id}")
    public PosteDTO getPoste(@PathVariable String id) {
        return posteService.findById(id);
    }
}
