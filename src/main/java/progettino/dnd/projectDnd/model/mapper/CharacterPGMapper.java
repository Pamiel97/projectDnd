package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.dtos.CampaignDto;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {AbilityPgMapper.class, SlotMapper.class})
public interface CharacterPGMapper {
    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "campaignId", source = "campaign.id"),
            @Mapping(target = "abilityPgs", qualifiedByName = "mapAbilityPgs")
    })
    CharacterPgDto toDTO(CharacterPg characterPG);

    @Mappings({
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "campaign.id", source = "campaignId"),
            @Mapping(target = "abilityPgs", ignore = true)
    })
    CharacterPg toEntity(CharacterPgDto characterPGDTO);

    @Named("mapAbilityPgs")
    default List<AbilityPgDto> mapAbilityPgs(List<AbilityPg> abilityPgs) {
        if (abilityPgs == null) return null;
        return abilityPgs.stream()
                .map(abilityPg -> {
                    AbilityPgDto dto = new AbilityPgDto();
                    dto.setId(abilityPg.getId());
                    if (abilityPg.getAbility() != null) {
                        dto.setAbilityId(abilityPg.getAbility().getId());
                    }
                    dto.setCompetence(abilityPg.isCompetence());
                    dto.setPoint(abilityPg.getPoint());
                    if (abilityPg.getPg() != null) {
                        dto.setPgId(abilityPg.getPg().getId());
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }
}