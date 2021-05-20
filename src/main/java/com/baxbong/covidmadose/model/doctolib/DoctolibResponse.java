package com.baxbong.covidmadose.model.doctolib;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DoctolibResponse {

    private List<DoctolibResponse.Availability> availabilities;

    @Data
    public static class Availability {
        private LocalDate date;
        private List<DoctolibResponse.Availability.Slots> slots;

        @Data
        public static class Slots {

        }
    }
}
