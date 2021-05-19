package com.baxbong.covidmadose.model.dao;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "centre_vaccination")
public class CentreVaccination {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String ville;
    private String nom;
    private String url;
    private String json;

}
