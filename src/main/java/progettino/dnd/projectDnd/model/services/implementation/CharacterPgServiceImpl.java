package progettino.dnd.projectDnd.model.services.implementation;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.exception.ConflictException;
import progettino.dnd.projectDnd.model.repositories.CampaignRepository;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.repositories.UserRepository;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CharacterPgServiceImpl implements CharacterPgService {

    private static final int DEFAULT_STARTING_LEVEL = 1;
    private static final int DEFAULT_STARTING_EXP = 0;

    private final CharacterPgRepository characterPgRepository;
    private final UserRepository userRepository;
    private final CampaignRepository campaignRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CharacterPgServiceImpl(CharacterPgRepository characterPgRepository, UserRepository userRepository, CampaignRepository campaignRepository, ModelMapper modelMapper) {
        this.characterPgRepository = characterPgRepository;
        this.userRepository = userRepository;
        this.campaignRepository = campaignRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public CharacterPgDto createCharacterPg(CharacterPgDto characterPgDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findByUsername(auth.getName())
                .orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

        Campaign activeCampaign = campaignRepository.findActiveByUser(currentUser)
                .orElseThrow(() -> new ResourceNotFoundException("No active campaign found"));

        characterPgRepository.findByNameAndUser(characterPgDto.getName(), currentUser)
                .ifPresent(c -> {
                    throw new ConflictException("Character with this name already exists");
                });

        CharacterPg characterPg = modelMapper.map(characterPgDto, CharacterPg.class);
        characterPg.setUser(currentUser);
        characterPg.setCampaign(activeCampaign);
        characterPg.setLevel(DEFAULT_STARTING_LEVEL);
        characterPg.setExp(DEFAULT_STARTING_EXP);
        characterPg.setActualHp(characterPg.getTotalHp());

        return modelMapper.map(characterPgRepository.save(characterPg), CharacterPgDto.class);
    }

    public List<CharacterPgDto> getAllCharacterPgs() {
        return characterPgRepository.findAll().stream()
                .map(pg -> modelMapper.map(pg, CharacterPgDto.class))
                .collect(Collectors.toList());
    }

    public CharacterPgDto getCharacterPgById(Long id) {
        return characterPgRepository.findById(id)
                .map(pg -> modelMapper.map(pg, CharacterPgDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
    }

    @Transactional
    public CharacterPgDto updateCharacterPg(Long id, CharacterPgDto characterPgDto) {
        CharacterPg existingCharacterPg = characterPgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));

        modelMapper.map(characterPgDto, existingCharacterPg);
        return modelMapper.map(characterPgRepository.save(existingCharacterPg), CharacterPgDto.class);
    }

    @Transactional
    public void deleteCharacterPg(Long id) {
        CharacterPg characterPg = characterPgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
        characterPgRepository.delete(characterPg);
    }

}
