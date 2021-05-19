package com.baxbong.covidmadose.controler;

import com.baxbong.covidmadose.model.DoctoLinks;
import com.baxbong.covidmadose.service.CovidMaDoseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
public class CovidMaDoseControler {

    private final CovidMaDoseService covidMaDoseService;

    @Autowired
    public CovidMaDoseControler(CovidMaDoseService covidMaDoseService) {
        this.covidMaDoseService = covidMaDoseService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<DoctoLinks>> getDose() {
        return covidMaDoseService.listDoses();
    }

}
