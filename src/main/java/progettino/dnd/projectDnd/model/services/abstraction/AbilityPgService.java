package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;

import java.util.List;

public interface AbilityPgService {
   List<AbilityPg> getAll();
    AbilityPg toEntity(AbilityPgDto abilityPgDto);
    AbilityPgDto toDto(AbilityPg abilityPg);
}
