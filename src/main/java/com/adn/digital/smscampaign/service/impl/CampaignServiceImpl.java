package com.adn.digital.smscampaign.service.impl;

import com.adn.digital.smscampaign.model.dao.Campaign;
import com.adn.digital.smscampaign.repository.CampaignRepository;
import com.adn.digital.smscampaign.repository.RecipientRepository;
import com.adn.digital.smscampaign.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CampaignServiceImpl implements CampaignService {

    private RecipientRepository recipientRepository;
    private CampaignRepository campaignRepository;

    @Autowired
    public CampaignServiceImpl(
            RecipientRepository recipientRepository,
            CampaignRepository campaignRepository
    ) {
        this.recipientRepository = recipientRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    @Async
    public CompletableFuture<List<Campaign>> start() {
        List<Campaign> campaigns = campaignRepository.findAll();



        return CompletableFuture.completedFuture(campaigns);
    }

}
