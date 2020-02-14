package com.adn.digital.smscampaign.service;

import com.adn.digital.smscampaign.model.dao.Campaign;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CampaignService {

    CompletableFuture<List<Campaign>> start();
}
