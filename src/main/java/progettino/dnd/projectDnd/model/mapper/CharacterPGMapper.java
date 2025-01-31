package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.dtos.CampaignDto;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.User;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SlotMapper.class})
public interface CharacterPGMapper {
//    // Mapping da CharacterPg a CharacterPgDto
//    @Mapping(target = "userId", source = "user.id")  // Mappa user.id a userId
//    @Mapping(target = "campaignId", source = "campaign.id")  // Mappa campaign.id a campaignId
//    CharacterPgDto toDTO(CharacterPg characterPG);
//
//    // Mapping inverso da CharacterPgDto a CharacterPg
//    @Mapping(target = "user.id", source = "userId")  // Mappa userId a user.id
//    @Mapping(target = "campaign.id", source = "campaignId")  // Mappa campaignId a campaign.id
//    CharacterPg toEntity(CharacterPgDto characterPGDTO);
//
//    // Mappatura personalizzata per convertire un long campaignId in un oggetto Campaign
//    default Campaign mapCampaign(long campaignId) {
//        Campaign campaign = new Campaign();
//        campaign.setId(campaignId);  // Impostiamo l'ID della campagna
//        return campaign;
//    }
//
//    // Mappatura inversa: Se vuoi mappare da Campaign a long campaignId
//    default long mapCampaignToId(Campaign campaign) {
//        return campaign != null ? campaign.getId() : 0L;  // Restituisce l'ID della campagna
//    }
//
//
//    @Mappings({
//            @Mapping(target = "abilityPgs", source = "abilityPgs")
//    })
//    CharacterPgDto toDto(CharacterPg characterPg);
//
//    List<AbilityPgDto> mapAbilities(List<AbilityPg> abilityPgs);


    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "campaignId", source = "campaign.id")
    CharacterPgDto toDTO(CharacterPg characterPg);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "campaign.id", source = "campaignId")
    CharacterPg toEntity(CharacterPgDto characterPgDTO);

    @Mappings({
            @Mapping(target = "abilityId", source = "ability.id"), // Map abilityId correttamente
            @Mapping(target = "pgId", source = "pg.id") // Map pgId correttamente
    })
    AbilityPgDto mapAbilityPg(AbilityPg abilityPg);

    List<AbilityPgDto> mapAbilities(List<AbilityPg> abilityPgs);







}
