package com.baxbong.covidmadose.model.repository;

import com.baxbong.covidmadose.model.dao.CentreVaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "centre_vaccination", path = "centre_vaccination")
public interface CentreVaccinationRepository extends JpaRepository<CentreVaccination, Long> {

    List<CentreVaccination> findAllByVille(String ville);

}
