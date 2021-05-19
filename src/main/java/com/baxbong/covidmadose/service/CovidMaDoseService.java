package com.baxbong.covidmadose.service;

import com.baxbong.covidmadose.model.DoctoLinks;
import com.baxbong.covidmadose.model.doctolib.AvailabilityDoctolib;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class CovidMaDoseService {

    public ResponseEntity<List<DoctoLinks>> listDoses() {

        RestTemplate restTemplate = new RestTemplate();

        DoctoLinks doctoLinks1 = DoctoLinks.builder()
                .urlToGo("https://www.doctolib.fr/centre-de-vaccinations-internationales/rennes/centre-de-vaccination-covid-19-rennes-liberte?highlight%5Bspeciality_ids%5D%5B%5D=5494")
                .jsonToParse("https://www.doctolib.fr/availabilities.json?start_date=2021-05-18&visit_motive_ids=2548527&agenda_ids=473601-473602-473604-473600-417731-472886-436810-471900-429575-429639-410820-410821-449554-436811-436809-436265-410823-417728-417727-417726-417725&insurance_sector=public&practice_ids=164684&destroy_temporary=true&limit=4")
                .build();

        DoctoLinks doctoLinks2 = DoctoLinks.builder()
                .urlToGo("https://www.doctolib.fr/centre-de-sante/ile-et-vilaine/centre-de-vaccination-covid-19-vaccimobile-35-ars-communes-ile-et-vilaine?highlight%5Bspeciality_ids%5D%5B%5D=5494")
                .jsonToParse("https://www.doctolib.fr/availabilities.json?start_date=2021-05-18&visit_motive_ids=2730650&agenda_ids=444293-448973-461899-448978-448980-448977-448976-448975-448974-471313-471302-461902-448979-461901&insurance_sector=public&practice_ids=178662&destroy_temporary=true&limit=4")
                .build();

        DoctoLinks doctoLinks3 = DoctoLinks.builder()
                .urlToGo("https://www.doctolib.fr/centre-de-sante/ile-et-vilaine/centre-de-vaccination-covid-19-vaccimobile-35-ars-communes-ile-et-vilaine?highlight%5Bspeciality_ids%5D%5B%5D=5494")
                .jsonToParse("https://www.doctolib.fr/availabilities.json?start_date=2021-05-18&visit_motive_ids=2815400&agenda_ids=465645-465669-465668-465671-465672-465659-465494-465663-465644-465657-465647-465665&insurance_sector=public&practice_ids=178662&destroy_temporary=true&limit=4")
                .build();

        DoctoLinks doctoLinks4 = DoctoLinks.builder()
                .urlToGo("https://www.doctolib.fr/centre-de-sante/rennes/centre-de-vaccination-covid-19-sos-medecins-rennes?highlight%5Bspeciality_ids%5D%5B%5D=5494")
                .jsonToParse("https://www.doctolib.fr/availabilities.json?start_date=2021-05-18&visit_motive_ids=2552100&agenda_ids=424721-412000-416903-412002-412030&insurance_sector=public&practice_ids=165130&destroy_temporary=true&limit=4")
                .build();

        DoctoLinks doctoLinks5 = DoctoLinks.builder()
                .urlToGo("https://www.doctolib.fr/centre-de-sante/saint-gregoire/centre-de-vaccination-de-saint-gregoire?highlight%5Bspeciality_ids%5D%5B%5D=5494")
                .jsonToParse("https://www.doctolib.fr/availabilities.json?start_date=2021-05-18&visit_motive_ids=2547466&agenda_ids=410311-450730-410312-429559&insurance_sector=public&practice_ids=164480&destroy_temporary=true&limit=4")
                .build();

        DoctoLinks doctoLinks6 = DoctoLinks.builder()
                .urlToGo("https://www.doctolib.fr/centre-de-sante/chantepie/centre-de-vaccination-covid-19-chantepie?highlight%5Bspeciality_ids%5D%5B%5D=5494")
                .jsonToParse("https://www.doctolib.fr/availabilities.json?start_date=2021-05-18&visit_motive_ids=2756293&agenda_ids=476759-470919-472565-470922-462767-462746-461961-458000-453116-453117&insurance_sector=public&practice_ids=181675&destroy_temporary=true&limit=4")
                .build();

        DoctoLinks doctoLinks7 = DoctoLinks.builder()
                .urlToGo("https://www.doctolib.fr/centre-de-sante/bruz/centre-de-vaccination-parc-expo-bruz?highlight%5Bspeciality_ids%5D%5B%5D=5494")
                .jsonToParse("https://www.doctolib.fr/availabilities.json?start_date=2021-05-18&visit_motive_ids=2676908&agenda_ids=433773-433775-448305-433777-448304-433774-448311-433771-448307&insurance_sector=public&practice_ids=174988&destroy_temporary=true&limit=4")
                .build();

        DoctoLinks doctoLinks8 = DoctoLinks.builder()
                .urlToGo("https://www.doctolib.fr/centre-de-sante/liffre/centre-de-vaccination-covid-19-de-liffre?highlight%5Bspeciality_ids%5D%5B%5D=5494")
                .jsonToParse("https://www.doctolib.fr/availabilities.json?start_date=2021-05-18&visit_motive_ids=2603130&agenda_ids=449252-421363-431307-445444&insurance_sector=public&practice_ids=169415&destroy_temporary=true&limit=4")
                .build();

        DoctoLinks doctoLinks9 = DoctoLinks.builder()
                .urlToGo("https://www.doctolib.fr/centre-de-sante/montfort-sur-meu/centre-de-vaccination-covid-19-de-broceliande?highlight%5Bspeciality_ids%5D%5B%5D=5494")
                .jsonToParse("https://www.doctolib.fr/availabilities.json?start_date=2021-05-18&visit_motive_ids=2565801&agenda_ids=441157-419822-414976&insurance_sector=public&practice_ids=166461&destroy_temporary=true&limit=4")
                .build();

        List<DoctoLinks> doctoLinks = List.of(doctoLinks1, doctoLinks2, doctoLinks3, doctoLinks4, doctoLinks5, doctoLinks6, doctoLinks7 ,doctoLinks8, doctoLinks9);

        List<DoctoLinks> doctoLinksWithDose = new ArrayList<>();

        for (DoctoLinks currentDoctoLink : doctoLinks) {
            AvailabilityDoctolib currentAvailabilityDoctolib = restTemplate.getForObject(currentDoctoLink.getJsonToParse(), AvailabilityDoctolib.class);
            int total = currentAvailabilityDoctolib.getTotal();
            if(total > 0 ) {
                System.out.println(new Date() + " " + currentDoctoLink.getUrlToGo());
                doctoLinksWithDose.add(currentDoctoLink);
            }
        }
        return ResponseEntity.ok(doctoLinksWithDose);
    }
}

