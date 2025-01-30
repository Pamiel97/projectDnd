package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import progettino.dnd.projectDnd.dtos.CampaignDto;
import progettino.dnd.projectDnd.model.entities.Campaign;

@Mapper(componentModel = "spring")
public interface CampaignMapper {
//    @Mapping(target = "users", ignore = true) // Ignora la lista users poiché verrà gestita separatamente
    Campaign toEntity(CampaignDto campaignDto);

    // Converte Campaign in CampaignDto
    CampaignDto toDto(Campaign campaign);
}
