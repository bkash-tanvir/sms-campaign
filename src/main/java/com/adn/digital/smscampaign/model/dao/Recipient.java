package com.adn.digital.smscampaign.model.dao;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "recipients")
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Campaign campaign;

    @Column(name="recipientNumber")
    private String recipientNumber;

    @Column(name="sender")
    private String sender;

    @Column(name="status")
    private String status;
}
