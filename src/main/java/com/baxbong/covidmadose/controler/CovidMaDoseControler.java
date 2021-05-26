package com.baxbong.covidmadose.controler;

import com.baxbong.covidmadose.model.dao.VaccinationCenter;
import com.baxbong.covidmadose.model.dao.City;
import com.baxbong.covidmadose.service.CovidMaDoseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class CovidMaDoseControler {

    private final CovidMaDoseService covidMaDoseService;

    @Autowired
    public CovidMaDoseControler(CovidMaDoseService covidMaDoseService) {
        this.covidMaDoseService = covidMaDoseService;
    }

    @GetMapping(path = "/cities/")
    public ResponseEntity<List<City>> getCities() {
        return ResponseEntity.ok(covidMaDoseService.getAllCities());
    }

    @GetMapping(path = "/vaccination-centers/{cityName}")
    public ResponseEntity<List<VaccinationCenter>> getVaccinationCenters(@PathVariable String cityName) {
        return ResponseEntity.ok(covidMaDoseService.getVaccinationCenters(cityName));
    }


    @GetMapping(path = "/chronodoses/{city}")
    public ResponseEntity<List<VaccinationCenter>> getDoses(@PathVariable String city) {
        return ResponseEntity.ok(covidMaDoseService.chronodoses(city));
    }

}
