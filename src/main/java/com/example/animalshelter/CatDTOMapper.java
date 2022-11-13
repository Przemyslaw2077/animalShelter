package com.example.animalshelter;

import org.springframework.stereotype.Service;

@Service
public class CatDTOMapper {

    Cat toEntity(CatDTO dto){
        Cat cat = new Cat();
        cat.setRace(dto.getRace());
        cat.setAge(dto.getAge());
        cat.setDescription(dto.getDescription());
        cat.setGender(dto.getGender());
        cat.setName(dto.getName());
        cat.setSize(dto.getSize());
        cat.setSpecies(dto.getSpecies());
        return cat;
    }

    CatDTO toDTO(Cat cat){
        CatDTO dto = new CatDTO();
        dto.setRace(cat.getRace());
        dto.setAge(cat.getAge());
        dto.setDescription(cat.getDescription());
        dto.setGender(cat.getGender());
        dto.setName(cat.getName());
        dto.setSize(cat.getSize());
        dto.setSpecies(cat.getSpecies());
        return dto;
    }

}
