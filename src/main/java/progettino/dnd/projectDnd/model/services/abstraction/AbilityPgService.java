package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface AbilityPgService {

     AbilityPg createAbilityPg(AbilityPg abilityPg, long abilityId, long characterId);
    List<AbilityPg> createMultipleAbilityPgs(List<AbilityPg> abilityPgs, long characterId);
    List<AbilityPgDto> getAbilitiesPgByCharacter(Long pgId);
    AbilityPg updateAbilityPg(long id, AbilityPg updatedAbilityPg) throws EntityNotFoundException;

}
