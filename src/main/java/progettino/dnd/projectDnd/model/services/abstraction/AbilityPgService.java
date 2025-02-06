package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;

import java.util.List;

public interface AbilityPgService {

     AbilityPg createAbilityPg(AbilityPg abilityPg, long abilityId, long characterId);
    List<AbilityPg> createMultipleAbilityPgs(List<AbilityPg> abilityPgs, long characterId);
    List<AbilityPgDto> getAbilitiesPgByCharacter(Long pgId);

}
