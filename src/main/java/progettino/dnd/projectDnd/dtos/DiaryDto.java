package progettino.dnd.projectDnd.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Diary;
import progettino.dnd.projectDnd.model.entities.Mission;

import java.util.ArrayList;
import java.util.List;

public class DiaryDto {
    private long id;
    private String name;
    private String description;
    @JsonBackReference
    private long pgId; // ID del personaggio associato
    private List<MissionDto> missions; // Lista delle missioni associate

    public DiaryDto() {
    }

    public DiaryDto(long id, String name, String description, long pgId, List<MissionDto> missions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pgId = pgId;
        this.missions = missions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPgId() {
        return pgId;
    }

    public void setPgId(long pgId) {
        this.pgId = pgId;
    }

    public List<MissionDto> getMissions() {
        return missions;
    }

    public void setMissions(List<MissionDto> missions) {
        this.missions = missions;
    }

    public static DiaryDto fromEntity(Diary diary) {
        if (diary == null) {
            return null;
        }

        DiaryDto diaryDto = new DiaryDto();
        diaryDto.setId(diary.getId());
        diaryDto.setName(diary.getName());
        diaryDto.setDescription(diary.getDescription());
        diaryDto.setPgId(diary.getPg() != null ? diary.getPg().getId() : 0); // Imposta l'ID del personaggio

        // Converti la lista di Mission in MissionDto
        if (diary.getMissions() != null) {
            List<MissionDto> missionDtos = new ArrayList<>();
            for (Mission mission : diary.getMissions()) {
                MissionDto missionDto = MissionDto.fromEntity(mission); // Usa la conversione anche per Mission
                missionDtos.add(missionDto);
            }
            diaryDto.setMissions(missionDtos);
        }

        return diaryDto;
    }





    // Metodi di Conversione da DTO a Entity
//    public static Diary toEntity(DiaryDto diaryDto) {
//        if (diaryDto == null) {
//            return null;
//        }
//
//        Diary diary = new Diary();
//        diary.setId(diaryDto.getId());
//        diary.setName(diaryDto.getName());
//        diary.setDescription(diaryDto.getDescription());
//
//        // Imposta il pg, se necessario (dovrai fare una ricerca o passare un'istanza di CharacterPg)
//        CharacterPg characterPg = new CharacterPg();
//        characterPg.setId(diaryDto.getPgId());
//        diary.setPg(characterPg);
//
//        // Converti la lista di MissionDto in Mission
//        if (diaryDto.getMissions() != null) {
//            List<Mission> missions = new ArrayList<>();
//            for (MissionDto missionDto : diaryDto.getMissions()) {
//                Mission mission = MissionDto.toEntity(missionDto); // Usa la conversione anche per Mission
//                mission.setDiary(diary);  // Associa il diario alla missione
//                missions.add(mission);
//            }
//            diary.setMissions(missions);
//        }
//
//        return diary;
//    }
}
