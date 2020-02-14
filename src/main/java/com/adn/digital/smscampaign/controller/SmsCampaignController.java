package com.adn.digital.smscampaign.controller;

import com.adn.digital.smscampaign.model.dto.CampaignResponse;
import com.adn.digital.smscampaign.service.CampaignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SmsCampaignController {

    private CampaignService campaignService;

    @Autowired
    public SmsCampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/start")
    public CampaignResponse startCampaign() {

        campaignService.start();

        return CampaignResponse.builder()
                .code(HttpStatus.OK.name())
                .message("SMS Campaign is ")
                .build();
    }
}
