package progettino.dnd.projectDnd.model.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import progettino.dnd.projectDnd.dtos.MissionDto;
import progettino.dnd.projectDnd.model.entities.Diary;
import progettino.dnd.projectDnd.model.entities.Mission;
import progettino.dnd.projectDnd.model.entities.NPC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MissionMapper {

    @Mapping(target = "diaryId", source = "diary.id")
    @Mapping(target = "npcIds", source = "npc")
    MissionDto toDto(Mission mission);

    @Mapping(target = "diary", source = "diaryId", qualifiedByName = "mapDiary")
    @Mapping(target = "npc", source = "npcIds", qualifiedByName = "mapNpcList")
    Mission toEntity(MissionDto missionDto);

    // Converte NPC -> List<Long>
    default List<Long> mapNpcListToIds(List<NPC> npcs) {
        return npcs != null ? npcs.stream().map(NPC::getId).toList() : new ArrayList<>();
    }

    // Converte List<Long> -> List<NPC>
    @Named("mapNpcList")
    default List<NPC> mapIdsToNpcList(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> {
            NPC npc = new NPC();
            npc.setId(id);
            return npc;
        }).toList() : new ArrayList<>();
    }

    // Mappa l'ID del diario a un oggetto Diary
    @Named("mapDiary")
    default Diary mapDiary(Long diaryId) {
        if (diaryId == null) {
            return null;
        }
        Diary diary = new Diary();
        diary.setId(diaryId);
        return diary;
    }
}
