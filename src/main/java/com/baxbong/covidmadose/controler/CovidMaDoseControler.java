package com.baxbong.covidmadose.controler;

import com.baxbong.covidmadose.model.dao.CentreVaccination;
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


    @GetMapping(path = "/{ville}")
    public ResponseEntity<List<CentreVaccination>> getDoses(@PathVariable String ville) {
        return covidMaDoseService.listDoses(ville);
    }

}
