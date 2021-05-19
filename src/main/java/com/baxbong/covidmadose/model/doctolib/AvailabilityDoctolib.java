package com.baxbong.covidmadose.model.doctolib;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AvailabilityDoctolib {

    private List<Availability> availabilities;

    @Data
    public static class Availability {
        private LocalDate date;
    }
}
