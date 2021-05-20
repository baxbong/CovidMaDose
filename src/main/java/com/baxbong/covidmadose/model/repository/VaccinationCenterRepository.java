package com.baxbong.covidmadose.model.repository;

import com.baxbong.covidmadose.model.dao.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "vaccination_center", path = "vaccination_center")
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Long> {

    List<VaccinationCenter> findAllByCityName(String city);

}
