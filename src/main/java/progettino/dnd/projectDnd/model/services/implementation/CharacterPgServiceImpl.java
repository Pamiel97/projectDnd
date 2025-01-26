package progettino.dnd.projectDnd.model.services.implementation;

import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.repositories.CampaignRepository;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.repositories.UserRepository;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterPgServiceImpl implements CharacterPgService {

    private final CharacterPgRepository characterPgRepository;
    private final UserRepository userRepository;
    private  final CampaignRepository campaignRepository;

    @Autowired
    public CharacterPgServiceImpl(
            CharacterPgRepository characterPgRepository,
            UserRepository userRepository,
            CampaignRepository campaignRepository){
        this.characterPgRepository = characterPgRepository;
        this.userRepository = userRepository;
        this.campaignRepository = campaignRepository;
    }

    @Transactional
    public CharacterPgDto createCharacterPg(CharacterPgDto characterPgDto){

        User user = userRepository.findById(characterPgDto.getUserId())
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Campaign campaign = campaignRepository.findById(characterPgDto.getCampaignId())
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));

        CharacterPg characterPg = new CharacterPg();
        BeanUtils.copyProperties(characterPgDto, characterPg);

        characterPg.setUser(user);
        characterPg.setCampaign(campaign);

        characterPg.setLevel(1);
        characterPg.setExp(0);
        characterPg.setActualHp(characterPg.getTotalHp());

        CharacterPg savedCharacterPg = characterPgRepository.save(characterPg);

        CharacterPgDto savedDto = new CharacterPgDto();
        BeanUtils.copyProperties(savedCharacterPg, savedDto);
        savedDto.setUserId(user.getId());
        savedDto.setCampaignId(campaign.getId());

        return savedDto;

    }

    public List<CharacterPgDto> getAllCharacterPgs() {
        return characterPgRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CharacterPgDto getCharacterPgById(Long id) {
        CharacterPg characterPg = characterPgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
        return convertToDto(characterPg);
    }

    @Transactional
    public CharacterPgDto updateCharacterPg(Long id, CharacterPgDto characterPgDto) {
        CharacterPg existingCharacterPg = characterPgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));

        BeanUtils.copyProperties(characterPgDto, existingCharacterPg, "id", "user", "campaign");

        CharacterPg updatedCharacterPg = characterPgRepository.save(existingCharacterPg);
        return convertToDto(updatedCharacterPg);
    }

    @Transactional
    public void deleteCharacterPg(Long id) {
        CharacterPg characterPg = characterPgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
        characterPgRepository.delete(characterPg);
    }

    private CharacterPgDto convertToDto(CharacterPg characterPg) {
        CharacterPgDto dto = new CharacterPgDto();
        BeanUtils.copyProperties(characterPg, dto);
        dto.setUserId(characterPg.getUser().getId());
        dto.setCampaignId(characterPg.getCampaign().getId());
        return dto;
    }
}
