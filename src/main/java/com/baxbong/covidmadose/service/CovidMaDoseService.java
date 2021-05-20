package com.baxbong.covidmadose.service;

import com.baxbong.covidmadose.model.dao.VaccinationCenter;
import com.baxbong.covidmadose.model.dao.City;
import com.baxbong.covidmadose.model.doctolib.DoctolibResponse;
import com.baxbong.covidmadose.model.repository.VaccinationCenterRepository;
import com.baxbong.covidmadose.model.repository.CityRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
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

    public static final String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36";
    public static final String USER_AGENT_KEY = "User-Agent";

    private final VaccinationCenterRepository vaccinationCenterRepository;
    private final CityRepository cityRepository;
    private final RestTemplate restTemplate;


    public CovidMaDoseService(VaccinationCenterRepository vaccinationCenterRepository, CityRepository cityRepository) {
        this.vaccinationCenterRepository = vaccinationCenterRepository;
        this.cityRepository = cityRepository;
        this.restTemplate = new RestTemplate();
    }

    public List<VaccinationCenter> chronodoses(String ville) {

        List<VaccinationCenter> vaccinationCenters = vaccinationCenterRepository.findAllByCityName(ville);
        List<VaccinationCenter> vaccinationsToReturnCenter = new ArrayList<>();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(USER_AGENT_KEY, USER_AGENT_VALUE);

        LocalDate today = LocalDate.now();
        LocalDate twoDaysFromNow = LocalDate.now().plusDays(2);

        for (VaccinationCenter currentVaccinationCenter : vaccinationCenters) {
            String urlJsonWithStartDate = currentVaccinationCenter.getJson() + "&start_date=" + today;
            ResponseEntity<DoctolibResponse> doctolibResponseEntity = restTemplate.exchange(urlJsonWithStartDate, HttpMethod.GET, new HttpEntity<>(headers), DoctolibResponse.class);
            DoctolibResponse doctolibResponse = doctolibResponseEntity.getBody();
            if(!CollectionUtils.isEmpty(doctolibResponse.getAvailabilities())) {
                for(DoctolibResponse.Availability availabilityDoctolib : doctolibResponse.getAvailabilities()) {
                    //Chronodose = Need to be available today or tomorrow
                    if(availabilityDoctolib.getDate().isBefore(twoDaysFromNow) && !CollectionUtils.isEmpty(availabilityDoctolib.getSlots())){
                        log.info(new Date() + " " + currentVaccinationCenter.getUrl());
                        vaccinationsToReturnCenter.add(currentVaccinationCenter);
                    }
                }
            }
        }
        return vaccinationsToReturnCenter;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}

