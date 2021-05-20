package com.baxbong.covidmadose.model.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vaccination_center")
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JsonBackReference
    private City city;
    private String name;
    private String url;
    private String json;

}
