package com.example.animalshelter;


import org.springframework.stereotype.Service;

@Service
public class AdoptionHistoryDTOMapper {

//    void toEntity(AdoptionHistoryDTO dto){
//        AdoptionHistory entity = new AdoptionHistory();
//        entity.setAdoptDate(dto.getAdoptDate());
//
//    }

    AdoptionHistoryDTO toDTO(AdoptionHistory entity){
        AdoptionHistoryDTO dto = new AdoptionHistoryDTO();
        dto.setAdoptDate(entity.getAdoptDate());
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
