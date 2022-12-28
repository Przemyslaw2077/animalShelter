package com.example.animalshelter.adopter;

import org.springframework.stereotype.Service;

@Service
public class AnimalAdopterDTOMapper {

    AnimalAdopterDTO toDTO(AnimalAdopter adopter){
        AnimalAdopterDTO dto = new AnimalAdopterDTO();
        dto.setId(adopter.getId());
        dto.setFirstName(adopter.getFirstName());
        dto.setLastName(adopter.getLastName());
        dto.setTelephoneNumber(adopter.getTelephoneNumber());
        dto.setAdoptedCats(adopter.getAdoptedCats());
        dto.setAdoptedDogs(adopter.getAdoptedDogs());
        return dto;
    }

    AnimalAdopter toEntity(AnimalAdopterDTO dto){
        AnimalAdopter entity = new AnimalAdopter();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setTelephoneNumber(dto.getTelephoneNumber());
        entity.setAdoptedCats(dto.getAdoptedCats());
        entity.setAdoptedDogs(dto.getAdoptedDogs());
        return entity;
    }
}
