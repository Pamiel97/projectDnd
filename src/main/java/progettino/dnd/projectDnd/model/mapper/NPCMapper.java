package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.NPCDto;
import progettino.dnd.projectDnd.model.entities.NPC;

@Mapper(componentModel = "spring")
public interface NPCMapper {

    NPC toEntity(NPCDto npcDto);

    // Mapping diretto Entity -> DTO
    NPCDto toDto(NPC npc);
}
