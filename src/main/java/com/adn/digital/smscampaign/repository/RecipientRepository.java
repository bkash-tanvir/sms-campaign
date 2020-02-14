package com.adn.digital.smscampaign.repository;

import com.adn.digital.smscampaign.model.dao.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, String> {
}
