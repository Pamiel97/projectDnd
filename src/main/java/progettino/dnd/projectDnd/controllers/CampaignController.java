package progettino.dnd.projectDnd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.CampaignDto;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.mapper.CampaignMapper;
import progettino.dnd.projectDnd.model.services.abstraction.CampaignService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/campaign")
@RestController
public class CampaignController {
    private CampaignService campaignService;
    private CampaignMapper campaignMapper;

    public CampaignController(CampaignService campaignService, CampaignMapper campaignMapper){
        this.campaignService = campaignService;
        this.campaignMapper = campaignMapper;
    }


    @PostMapping("/create")
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto campaignDto,
                                                      @AuthenticationPrincipal User user) {
        try {
            // Mappa il CampaignDto in un'entità Campaign
            Campaign campaign = campaignMapper.toEntity(campaignDto);

            // Chiamata al servizio per creare la campagna e associare l'utente autenticato
            Campaign createdCampaign = campaignService.createCampaign(campaign, user.getId());

            // Converte la campagna creata in un CampaignDto per restituirla al client
            CampaignDto createdCampaignDto = campaignMapper.toDto(createdCampaign);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdCampaignDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/my-campaigns")
    public ResponseEntity<List<CampaignDto>> getUserCampaigns(@AuthenticationPrincipal User user) {
        try {

            List<Campaign> campaigns = campaignService.getCampaignsByUserId(user.getId());

            List<CampaignDto> campaignDtos = campaigns.stream()
                    .map(campaignMapper::toDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(campaignDtos);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
