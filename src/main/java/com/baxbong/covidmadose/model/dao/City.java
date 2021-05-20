package com.baxbong.covidmadose.model.dao;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "city")
    private List<VaccinationCenter> vaccinationCenters;

}
