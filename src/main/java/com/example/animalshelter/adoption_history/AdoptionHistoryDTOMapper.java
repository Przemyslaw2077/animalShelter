package com.example.animalshelter.adoption_history;


import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class AdoptionHistoryDTOMapper {


    AdoptionHistoryDTO toDTO(AdoptionHistory entity){
        AdoptionHistoryDTO dto = new AdoptionHistoryDTO();
        dto.setAdoptDate(entity.getAdoptDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd\nHH:mm")));
        dto.setAdopterFirstName(entity.getAdopter().getFirstName());
        dto.setAdopterLastName(entity.getAdopter().getLastName());
        dto.setEmployeeFirstName(entity.getAnimalIssuingEmployee().getFirstName());
        dto.setEmployeeLastName(entity.getAnimalIssuingEmployee().getLastName());
        if (entity.getAdoptedCat() != null){
            dto.setAnimalName(entity.getAdoptedCat().getName());
            dto.setAnimalSpecies(entity.getAdoptedCat().getSpecies().getTranslation());
        }else {
            dto.setAnimalName(entity.getAdoptedDog().getName());
            dto.setAnimalSpecies(entity.getAdoptedDog().getSpecies().getTranslation());
        }

        return dto;

    }
}
