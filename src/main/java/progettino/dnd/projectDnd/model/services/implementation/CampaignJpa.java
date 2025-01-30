package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.CampaignRepository;
import progettino.dnd.projectDnd.model.repositories.security.UserRepository;
import progettino.dnd.projectDnd.model.services.abstraction.CampaignService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignJpa implements CampaignService {
    private CampaignRepository campaignRepository;
    private UserRepository userRepository;

    @Autowired
    public CampaignJpa(CampaignRepository campaignRepository, UserRepository userRepository){
        this.campaignRepository=campaignRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Campaign> findCampaignById(long id) {
        return campaignRepository.findById(id);
    }

    @Override
    public Campaign createCampaign(Campaign campaign, long userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Utente con ID " + userId + " non trovato"));

        // 2. Aggiungi l'utente alla campagna
       // campaign.setUsers(List.of(user));  // Associa l'utente alla campagna

        // 3. Aggiungi la campagna alla lista di campagne dell'utente
        user.getCampaigns().add(campaign);

        // 4. Salva la campagna (e l'utente sarà aggiornato automaticamente grazie alla relazione Many-to-Many)
        return campaignRepository.save(campaign);
    }

    @Override
    public List<Campaign> getCampaignsByUserId(long userId) throws EntityNotFoundException{
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Utente con ID " + userId + " non trovato"));

        return new ArrayList<>(user.getCampaigns());
    }
}
