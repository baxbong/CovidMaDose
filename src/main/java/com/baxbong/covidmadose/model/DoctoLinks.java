package com.baxbong.covidmadose.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctoLinks {

    private String urlToGo;
    private String jsonToParse;

}
