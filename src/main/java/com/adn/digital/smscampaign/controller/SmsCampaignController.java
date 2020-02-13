package com.adn.digital.smscampaign.controller;

import com.adn.digital.smscampaign.model.dto.CampaignResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SmsCampaignController {

    public SmsCampaignController() {

    }

    public CampaignResponse startCampaign() {



        return CampaignResponse.builder()
                .code(HttpStatus.OK.name())
                .message("SMS Campaign is ")
                .build();
    }
}
