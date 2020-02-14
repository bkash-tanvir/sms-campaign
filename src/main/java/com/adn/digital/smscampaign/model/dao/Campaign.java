package com.adn.digital.smscampaign.model.dao;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="message")
    private String message;

    @Column(name="status")
    private String status;
}
