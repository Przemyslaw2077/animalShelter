package com.example.animalshelter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private CatRepository catRepository;
    private DogRepository dogRepository;
    private CatDTOMapper catDTOMapper;
    private DogDTOMapper dogDTOMapper;

    public AnimalService(CatRepository catRepository, DogRepository dogRepository, CatDTOMapper catDTOMapper, DogDTOMapper dogDTOMapper) {
        this.catRepository = catRepository;
        this.dogRepository = dogRepository;
        this.catDTOMapper = catDTOMapper;
        this.dogDTOMapper = dogDTOMapper;
    }



    List<AnimalDTO> findAll(){
        List<AnimalDTO> animals = new ArrayList<>();

        List<CatDTO> catDTOS = catRepository.findAll().stream().map(catDTOMapper::toDTO).toList();
        List<DogDTO> dogDTOS = dogRepository.findAll().stream().map(dogDTOMapper::toDTO).toList();

        animals.addAll(catDTOS);
        animals.addAll(dogDTOS);

        return animals;
    }

    List<AnimalDTO> findAllBySpecies(AnimalStatistics.Species species){
        return findAll().stream().filter(it -> it.getSpecies().equals(species)).toList();
    }

    List<AnimalDTO> findAllByGender(AnimalStatistics.Gender gender){
        return findAll().stream().filter(it -> it.getGender().equals(gender)).toList();
    }
}
