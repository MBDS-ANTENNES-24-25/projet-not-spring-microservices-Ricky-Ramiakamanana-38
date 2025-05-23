package fr.itu.mbds.competence.mapper;

import fr.itu.mbds.competence.dto.CompetenceDTO;
import fr.itu.mbds.competence.entity.Competence;
import org.springframework.stereotype.Component;

@Component
public class CompetenceMapper {

    public CompetenceDTO toDTO(Competence competence) {
        return new CompetenceDTO(competence.getId(), competence.getNom());
    }

    public Competence toEntity(CompetenceDTO dto) {
        if (dto != null) {
            return new Competence(dto.getId(), dto.getNom());
        }
        return null;
    }
}
