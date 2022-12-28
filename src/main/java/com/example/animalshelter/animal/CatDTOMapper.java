package com.example.animalshelter.animal;

import com.example.animalshelter.animal.Cat;
import com.example.animalshelter.animal.CatDTO;
import org.springframework.stereotype.Service;

@Service
public class CatDTOMapper {

    public Cat toEntity(CatDTO dto){
        Cat cat = new Cat();
        cat.setRace(dto.getRace());
        cat.setAge(dto.getAge());
        cat.setDescription(dto.getDescription());
        cat.setGender(dto.getGender());
        cat.setName(dto.getName());
        cat.setSize(dto.getSize());
        cat.setSpecies(dto.getSpecies());
        cat.setId(dto.getId());
        return cat;
    }

    public CatDTO toDTO(Cat entity){
        CatDTO dto = new CatDTO();
        dto.setRace(entity.getRace());
        dto.setAge(entity.getAge());
        dto.setDescription(entity.getDescription());
        dto.setGender(entity.getGender());
        dto.setName(entity.getName());
        dto.setSize(entity.getSize());
        dto.setSpecies(entity.getSpecies());
        dto.setId(entity.getId());
        dto.setOwner(entity.getOwner());
        dto.setAdopted(entity.isAdopted());
        return dto;
    }

    public CatDTO animalDTOToCatDTO(AnimalDTO animalDTO){
        CatDTO catDTO = new CatDTO();
        catDTO.setAge(animalDTO.getAge());
        catDTO.setDescription(animalDTO.getDescription());
        catDTO.setGender(animalDTO.getGender());
        catDTO.setName(animalDTO.getName());
        catDTO.setSize(animalDTO.getSize());
        catDTO.setSpecies(animalDTO.getSpecies());
        return catDTO;
    }

}
