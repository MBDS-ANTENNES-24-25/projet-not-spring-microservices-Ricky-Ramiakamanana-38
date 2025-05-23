package fr.itu.mbds.poste.service.impl;

import fr.itu.mbds.poste.client.CompetenceClient;
import fr.itu.mbds.poste.dto.PosteDTO;
import fr.itu.mbds.poste.entity.Poste;
import fr.itu.mbds.poste.mapper.PosteMapper;
import fr.itu.mbds.poste.model.Competence;
import fr.itu.mbds.poste.repository.PosteRepository;
import fr.itu.mbds.poste.service.PosteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosteServiceImpl implements PosteService {

    private final PosteRepository posteRepository;
    private final PosteMapper posteMapper;
    private final CompetenceClient competenceClient;

    public PosteServiceImpl(PosteRepository posteRepository,
                            PosteMapper posteMapper,
                            CompetenceClient competenceClient) {
        this.posteRepository = posteRepository;
        this.posteMapper = posteMapper;
        this.competenceClient = competenceClient;
    }

    @Override
    public List<PosteDTO> findAll() {
        return posteRepository.findAll().stream()
                .map(poste -> {
                    PosteDTO dto = posteMapper.toDTO(poste);
                    List<Competence> competences = poste.getCompetenceIds()
                            .stream()
                            .map(competenceClient::getCompetenceById)
                            .collect(Collectors.toList());
                    dto.setCompetences(competences);
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public PosteDTO findById(String id) {
        Poste poste = posteRepository.findById(id).orElse(null);
        if (poste == null) return null;

        PosteDTO dto = posteMapper.toDTO(poste);
        List<Competence> competences = poste.getCompetenceIds()
                .stream()
                .map(competenceClient::getCompetenceById)
                .collect(Collectors.toList());
        dto.setCompetences(competences);
        return dto;
    }
}
