package com.example.animalshelter;


import com.example.animalshelter.animal.*;
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

}
