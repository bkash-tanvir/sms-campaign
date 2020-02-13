package com.adn.digital.smscampaign.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CampaignResponse {

    private String code;
    private String message;
}
