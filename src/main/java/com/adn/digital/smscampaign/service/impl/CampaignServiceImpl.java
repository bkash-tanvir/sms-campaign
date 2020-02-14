package com.adn.digital.smscampaign.service.impl;

import com.adn.digital.smscampaign.model.dao.Campaign;
import com.adn.digital.smscampaign.model.dao.Recipient;
import com.adn.digital.smscampaign.model.dao.SentBox;
import com.adn.digital.smscampaign.repository.CampaignRepository;
import com.adn.digital.smscampaign.repository.RecipientRepository;
import com.adn.digital.smscampaign.repository.SentBoxRepository;
import com.adn.digital.smscampaign.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class CampaignServiceImpl implements CampaignService {

    private RecipientRepository recipientRepository;
    private CampaignRepository campaignRepository;
    private SentBoxRepository sentBoxRepository;

    @Autowired
    public CampaignServiceImpl(
            RecipientRepository recipientRepository,
            CampaignRepository campaignRepository,
            SentBoxRepository sentBoxRepository
    ) {
        this.recipientRepository = recipientRepository;
        this.campaignRepository = campaignRepository;
        this.sentBoxRepository = sentBoxRepository;
    }

    @Override
    public void start() {
        var campaigns = campaignRepository.findAll().iterator();

        sentBoxUpdate(campaigns);
    }

    @Async
    protected CompletableFuture<List<SentBox>> sentBoxUpdate(Iterator<Campaign> campaigns) {

        List<SentBox> sentBoxes = new ArrayList<>();

        while (campaigns.hasNext()){
            Campaign campaign = campaigns.next();
            List<Recipient> recipientList = recipientRepository.findAllByCampaign(campaign);

            for (Recipient recipient : recipientList){

                sentBoxes.add(SentBox.builder()
                        .campaign(campaign)
                        .recipientNumber(recipient.getRecipientNumber())
                        .createdTime(formattedDateTime(new Date()))
                        .build());
            }
        }

        List<SentBox> completedCampaign = (List<SentBox>) sentBoxRepository.saveAll(sentBoxes);

        return CompletableFuture.completedFuture(completedCampaign);
    }


    private String formattedDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS Z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+6"));

        return sdf.format(date);
    }

}
