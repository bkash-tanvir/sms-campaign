package com.adn.digital.smscampaign.repository;

import com.adn.digital.smscampaign.model.dao.Recipient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, String> {
}
