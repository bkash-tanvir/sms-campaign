package com.adn.digital.smscampaign.service.impl;

import com.adn.digital.smscampaign.model.dao.Recipient;
import com.adn.digital.smscampaign.repository.RecipientRepository;
import com.adn.digital.smscampaign.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CampaignServiceImpl implements CampaignService {

    private RecipientRepository recipientRepository;

    @Autowired
    public CampaignServiceImpl(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    @Override
    public void start() {
        Iterable<Recipient> recipients = recipientRepository.findAll();
    }
}
