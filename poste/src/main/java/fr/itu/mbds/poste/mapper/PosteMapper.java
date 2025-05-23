package fr.itu.mbds.poste.mapper;

import fr.itu.mbds.poste.dto.PosteDTO;
import fr.itu.mbds.poste.entity.Poste;
import org.springframework.stereotype.Component;

@Component
public class PosteMapper {
    public PosteDTO toDTO(Poste poste) {
        return PosteDTO.builder()
                .id(poste.getId())
                .nom(poste.getNom())
                .competenceIds(poste.getCompetenceIds())
                .build(); // competences laissé à null ici
    }

    public Poste toEntity(PosteDTO dto) {
        if (dto != null) {
            return Poste.builder()
                    .id(dto.getId())
                    .nom(dto.getNom())
                    .competenceIds(dto.getCompetenceIds())
                    .build();
        }
        return null;
    }
}
