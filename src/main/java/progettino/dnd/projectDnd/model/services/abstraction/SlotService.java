package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.dtos.SlotDto;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.Slot;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface SlotService {
    Slot createSlot(Slot slot, long id) throws EntityNotFoundException;
    public List<SlotDto> getSlotsByCharacter(Long characterId);
}
