package com.adn.digital.smscampaign.model.dao;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "sent_box")
public class SentBox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Campaign campaign;

    @Column(name="recipientNumber")
    private String recipientNumber;

    @Column(name="createdTime")
    private String createdTime;

}
