package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface CharacterPgService {

   CharacterPgDto createCharacterPg(CharacterPg characterPg, long userId, long campaignId) throws EntityNotFoundException;
//    List<CharacterPgDto> getAllCharacterPgs();
//    CharacterPgDto getCharacterPgById(Long id);
//    CharacterPgDto updateCharacterPg(Long id, CharacterPgDto characterPgDto);
//    void deleteCharacterPg(Long id);





}
