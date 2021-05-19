package com.baxbong.covidmadose.service;

import com.baxbong.covidmadose.model.dao.CentreVaccination;
import com.baxbong.covidmadose.model.doctolib.AvailabilityDoctolib;
import com.baxbong.covidmadose.model.repository.CentreVaccinationRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Log4j
public class CovidMaDoseService {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    CentreVaccinationRepository centreVaccinationRepository;

    public ResponseEntity<List<CentreVaccination>> chronodoses(String ville) {

        List<CentreVaccination> centreVaccinations = centreVaccinationRepository.findAllByVille(ville);
        List<CentreVaccination> centreVaccinationsToReturn = new ArrayList<>();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");

        for (CentreVaccination currentCentreVaccination : centreVaccinations) {
            ResponseEntity<AvailabilityDoctolib> currentAvailabilityDoctolib = restTemplate.exchange(currentCentreVaccination.getJson(), HttpMethod.GET, new HttpEntity<Object>(headers), AvailabilityDoctolib.class);
            AvailabilityDoctolib availabilityDoctolib = currentAvailabilityDoctolib.getBody();
            if(!CollectionUtils.isEmpty(availabilityDoctolib.getAvailabilities())) {
                LocalDate firstAppointmentDate = availabilityDoctolib.getAvailabilities().get(0).getDate();
                LocalDate twoDaysFromNow = LocalDate.now().plusDays(2);
                if(firstAppointmentDate.isBefore(twoDaysFromNow)) {
                    log.info(new Date() + " " + currentCentreVaccination.getUrl());
                    centreVaccinationsToReturn.add(currentCentreVaccination);
                }
            }
        }
        return ResponseEntity.ok(centreVaccinationsToReturn);
    }
}

