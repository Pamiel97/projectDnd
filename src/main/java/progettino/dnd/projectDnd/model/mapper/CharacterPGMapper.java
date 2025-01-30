package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;

@Mapper(componentModel = "spring")
public interface CharacterPGMapper {
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "campaign.id", source = "campaign.id")
    CharacterPgDto toDTO(CharacterPg characterPG);

    // Metodo per mappare dal DTO all'entità
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "campaign.id", source = "campaign.id")
    CharacterPg toEntity(CharacterPgDto characterPGDTO);
}
