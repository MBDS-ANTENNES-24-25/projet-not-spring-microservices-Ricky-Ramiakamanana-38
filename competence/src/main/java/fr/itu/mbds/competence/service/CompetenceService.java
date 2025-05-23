package fr.itu.mbds.competence.service;

import fr.itu.mbds.competence.dto.CompetenceDTO;

import java.util.List;

public interface CompetenceService {
    List<CompetenceDTO> findAll();

    CompetenceDTO findById(Long id);
}
