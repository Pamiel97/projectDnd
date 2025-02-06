package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CharacterPgService {

   CharacterPg createCharacterPg(CharacterPg characterPg, long userId, long campaignId) throws EntityNotFoundException;
   List<CharacterPg> getAllCharacterPgs();

   CharacterPg addTalentToPg(Long pgId, Long talentId) throws  EntityNotFoundException;
   CharacterPg addTraitToPg(Long pgId, Long traitId) throws  EntityNotFoundException;





}
