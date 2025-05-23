package fr.itu.mbds.poste.mapper;

import fr.itu.mbds.poste.dto.PosteDTO;
import fr.itu.mbds.poste.entity.Poste;
import org.springframework.stereotype.Component;

@Component
public class PosteMapper {
    public PosteDTO toDTO(Poste poste) {
        return new PosteDTO(poste.getId(), poste.getNom(), poste.getCompetenceIds());
    }

    public Poste toEntity(PosteDTO dto) {
        if (dto != null) {
            return new Poste(dto.getId(), dto.getNom(), dto.getCompetenceIds());
        }
        return null;
    }
}
