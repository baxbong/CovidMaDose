package com.baxbong.covidmadose.model.repository;

import com.baxbong.covidmadose.model.dao.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityRepository extends JpaRepository<City, Long> {

}
