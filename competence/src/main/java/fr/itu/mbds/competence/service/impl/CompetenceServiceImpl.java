package fr.itu.mbds.competence.service.impl;

import fr.itu.mbds.competence.dto.CompetenceDTO;
import fr.itu.mbds.competence.entity.Competence;
import fr.itu.mbds.competence.mapper.CompetenceMapper;
import fr.itu.mbds.competence.repository.CompetenceRepository;
import fr.itu.mbds.competence.service.CompetenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository competenceRepository;
    private final CompetenceMapper competenceMapper;

    public CompetenceServiceImpl(CompetenceRepository competenceRepository, CompetenceMapper competenceMapper) {
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
    }

    @Override
    public List<CompetenceDTO> findAll() {
        return competenceRepository.findAll().stream()
                .map(competenceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompetenceDTO findById(Long id) {
        Competence competence = competenceRepository.findById(id).orElse(null);
        if (competence != null)
            return competenceMapper.toDTO(competence);
        return null;
    }
}
