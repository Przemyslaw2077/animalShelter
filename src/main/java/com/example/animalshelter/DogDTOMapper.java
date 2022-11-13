package com.example.animalshelter;


import org.springframework.stereotype.Service;

@Service
public class DogDTOMapper {

    Dog toEntity(DogDTO dto){
        Dog dog = new Dog();
        dog.setRace(dto.getRace());
        dog.setAge(dto.getAge());
        dog.setDescription(dto.getDescription());
        dog.setGender(dto.getGender());
        dog.setName(dto.getName());
        dog.setSize(dto.getSize());
        dog.setSpecies(dto.getSpecies());
        return dog;
    }


    DogDTO toDTO(Dog dog){
        DogDTO dto = new DogDTO();
        dto.setRace(dog.getRace());
        dto.setAge(dog.getAge());
        dto.setDescription(dog.getDescription());
        dto.setGender(dog.getGender());
        dto.setName(dog.getName());
        dto.setSize(dog.getSize());
        dto.setSpecies(dog.getSpecies());
        return dto;
    }
}
