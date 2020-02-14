package com.adn.digital.smscampaign.repository;

import com.adn.digital.smscampaign.model.dao.SentBox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentBoxRepository extends CrudRepository<SentBox, String> {

}
