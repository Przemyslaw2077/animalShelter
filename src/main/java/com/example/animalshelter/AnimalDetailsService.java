package com.example.animalshelter;


import org.springframework.stereotype.Service;

@Service
public class AnimalDetailsService {

    private CatRepository catRepository;
    private DogRepository dogRepository;
    private CatDTOMapper catDTOMapper;
    private DogDTOMapper dogDTOMapper;

    public AnimalDetailsService(CatRepository catRepository, DogRepository dogRepository, CatDTOMapper catDTOMapper, DogDTOMapper dogDTOMapper) {
        this.catRepository = catRepository;
        this.dogRepository = dogRepository;
        this.catDTOMapper = catDTOMapper;
        this.dogDTOMapper = dogDTOMapper;
    }

    AnimalDTO animalDetails(String name, AnimalStatistics.Species species) {
        AnimalDTO animal;

        if (species.equals(AnimalStatistics.Species.CAT)) {
            animal = catDTOMapper.toDTO(catRepository.findByName(name).get());
        } else
            animal = dogDTOMapper.toDTO((dogRepository.findByName(name).get()));
        return animal;
    }
}
