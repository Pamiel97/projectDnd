package progettino.dnd.projectDnd.model.services.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

@Service
@Slf4j
public class CharacterPgJpa implements CharacterPgService {
//    private static final int DEFAULT_STARTING_LEVEL = 1;
//    private static final int DEFAULT_STARTING_EXP = 0;
//
//    private final CharacterPgRepository characterPgRepository;
//    private final UserDetailRepository userRepository;
//    private final CampaignRepository campaignRepository;
//    private final BagRepository bagRepository;
//    private final DiaryRepository diaryRepository;
//    private final ModelMapper modelMapper;
//
//    public CharacterPgServiceImpl(CharacterPgRepository characterPgRepository, UserDetailRepository userRepository, CampaignRepository campaignRepository, BagRepository bagRepository, DiaryRepository diaryRepository, ModelMapper modelMapper) {
//        this.characterPgRepository = characterPgRepository;
//        this.userRepository = userRepository;
//        this.campaignRepository = campaignRepository;
//        this.bagRepository = bagRepository;
//        this.diaryRepository = diaryRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Transactional
//    public CharacterPgDto createCharacterPg(CharacterPgDto characterPgDto, long userId) {
//
//        User currentUser = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("Current user not found"));
//
//        Campaign activeCampaign = campaignRepository.findActiveByUser(currentUser)
//                .orElseThrow(() -> new ResourceNotFoundException("No active campaign found"));
//
//        characterPgRepository.findByNameAndUser(characterPgDto.getName(), currentUser)
//                .ifPresent(c -> {
//                    throw new ConflictException("Character with this name already exists");
//                });
//
//        CharacterPg characterPg = modelMapper.map(characterPgDto, CharacterPg.class);
//        characterPg.setUser(currentUser);
//        characterPg.setCampaign(activeCampaign);
//        characterPg.setLevel(DEFAULT_STARTING_LEVEL);
//        characterPg.setExp(DEFAULT_STARTING_EXP);
//        characterPg.setActualHp(characterPg.getTotalHp());
//
//        // Initialize collections
//        characterPg.setSlots(new ArrayList<>());
//        characterPg.setAbilityPgs(new ArrayList<>());
//        characterPg.setStaticList(new ArrayList<>());
//        characterPg.setTiriSalvezza(new ArrayList<>());
//        characterPg.setTalents(new ArrayList<>());
//        characterPg.setTraits(new ArrayList<>());
//
//        // Create and link Bag
//        Bag bag = new Bag();
//        bag.setPg(characterPg);
//        bag.setPotions(new ArrayList<>());
//        bag.setEquips(new ArrayList<>());
//        bag.setWeapons(new ArrayList<>());
//        bag.setObjects(new ArrayList<>());
//        characterPg.setBag(bag);
//
//        // Create and link Diary
//        Diary diary = new Diary();
//        diary.setPg(characterPg);
//        diary.setName(characterPg.getName() + "'s Diary");
//        diary.setDescription("Personal diary of " + characterPg.getName());
//        diary.setMissions(new ArrayList<>());
//        characterPg.setDiary(diary);
//
//        CharacterPg savedCharacterPg = characterPgRepository.save(characterPg);
//        return modelMapper.map(savedCharacterPg, CharacterPgDto.class);
//    }
//
//    public List<CharacterPgDto> getAllCharacterPgs() {
//        return characterPgRepository.findAll().stream()
//                .map(pg -> modelMapper.map(pg, CharacterPgDto.class))
//                .collect(Collectors.toList());
//    }
//
//    public CharacterPgDto getCharacterPgById(Long id) {
//        return characterPgRepository.findById(id)
//                .map(pg -> modelMapper.map(pg, CharacterPgDto.class))
//                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
//    }
//
//    @Transactional
//    public CharacterPgDto updateCharacterPg(Long id, CharacterPgDto characterPgDto) {
//        CharacterPg existingCharacterPg = characterPgRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
//
//        modelMapper.map(characterPgDto, existingCharacterPg);
//        return modelMapper.map(characterPgRepository.save(existingCharacterPg), CharacterPgDto.class);
//    }
//
//    @Transactional
//    public void deleteCharacterPg(Long id) {
//        CharacterPg characterPg = characterPgRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
//        characterPgRepository.delete(characterPg);
//    }
}
