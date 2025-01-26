package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.dtos.CharacterPgDto;

import java.util.List;

public interface CharacterPgService {

    public CharacterPgDto createCharacterPg(CharacterPgDto characterPgDto);
    public List<CharacterPgDto> getAllCharacterPgs();
    public CharacterPgDto getCharacterPgById(Long id);
    public CharacterPgDto updateCharacterPg(Long id, CharacterPgDto characterPgDto);
    public void deleteCharacterPg(Long id);





}
