package com.adn.digital.smscampaign.repository;

import com.adn.digital.smscampaign.model.dao.Campaign;
import com.adn.digital.smscampaign.model.dao.Recipient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, String> {

    List<Recipient> findAllByCampaign(Campaign campaign);
}
