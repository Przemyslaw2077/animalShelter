package com.example.animalshelter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AdoptionHistoryDTO {

    private String employeeFirstName;
    private String employeeLastName;
    private String animalName;
    private String animalSpecies;
    private String adopterFirstName;
    private String adopterLastName;
    private LocalDateTime adoptDate;
}
