package fr.itu.mbds.poste.service.impl;

import fr.itu.mbds.poste.dto.PosteDTO;
import fr.itu.mbds.poste.entity.Poste;
import fr.itu.mbds.poste.mapper.PosteMapper;
import fr.itu.mbds.poste.repository.PosteRepository;
import fr.itu.mbds.poste.service.PosteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosteServiceImpl implements PosteService {

    private final PosteRepository posteRepository;
    private final PosteMapper posteMapper;

    public PosteServiceImpl(PosteRepository posteRepository, PosteMapper posteMapper) {
        this.posteRepository = posteRepository;
        this.posteMapper = posteMapper;
    }

    @Override
    public List<PosteDTO> findAll() {
        return posteRepository.findAll().stream()
                .map(posteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PosteDTO findById(String id) {
        Poste poste = posteRepository.findById(id).orElse(null);
        if (poste != null)
            return posteMapper.toDTO(poste);
        return null;
    }
}
