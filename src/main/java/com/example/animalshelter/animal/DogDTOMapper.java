package com.example.animalshelter.animal;


import com.example.animalshelter.animal.Dog;
import com.example.animalshelter.animal.DogDTO;
import org.springframework.stereotype.Service;

@Service
public class DogDTOMapper {

    public Dog toEntity(DogDTO dto){
        Dog dog = new Dog();
        dog.setRace(dto.getRace());
        dog.setAge(dto.getAge());
        dog.setDescription(dto.getDescription());
        dog.setGender(dto.getGender());
        dog.setName(dto.getName());
        dog.setSize(dto.getSize());
        dog.setSpecies(dto.getSpecies());
        dog.setId(dto.getId());
        return dog;
    }


    public DogDTO toDTO(Dog entity){
        DogDTO dto = new DogDTO();
        dto.setRace(entity.getRace());
        dto.setAge(entity.getAge());
        dto.setDescription(entity.getDescription());
        dto.setGender(entity.getGender());
        dto.setName(entity.getName());
        dto.setSize(entity.getSize());
        dto.setSpecies(entity.getSpecies());
        dto.setId(entity.getId());
        dto.setAdopted(entity.isAdopted());
        dto.setOwner(entity.getOwner());
        return dto;
    }

    public DogDTO animalDTOToDogDTO(AnimalDTO animalDTO){
        DogDTO dogDTO = new DogDTO();
        dogDTO.setAge(animalDTO.getAge());
        dogDTO.setDescription(animalDTO.getDescription());
        dogDTO.setGender(animalDTO.getGender());
        dogDTO.setName(animalDTO.getName());
        dogDTO.setSize(animalDTO.getSize());
        dogDTO.setSpecies(animalDTO.getSpecies());
        return dogDTO;
    }
}
