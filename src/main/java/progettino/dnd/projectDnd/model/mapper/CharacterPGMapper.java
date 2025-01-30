package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;

@Mapper(componentModel = "spring")
public interface CharacterPGMapper {
    CharacterPgDto toDTO(CharacterPg characterPG);

    // Metodo per mappare dal DTO all'entità
    CharacterPg toEntity(CharacterPgDto characterPGDTO);
}
