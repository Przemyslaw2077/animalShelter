package com.example.animalshelter;

import com.example.animalshelter.animal.CatDTOMapper;
import com.example.animalshelter.animal.CatRepository;
import com.example.animalshelter.animal.DogDTOMapper;
import com.example.animalshelter.animal.DogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AnimalServiceTest {
    private CatRepository catRepository;
    private DogRepository dogRepository;
    private CatDTOMapper catDTOMapper;
    private DogDTOMapper dogDTOMapper;
    private AnimalService animalService;


    @BeforeEach
    void init(){
        catRepository = Mockito.mock(CatRepository.class);
        dogRepository = Mockito.mock(DogRepository.class);
        catDTOMapper = Mockito.mock(CatDTOMapper.class);
        dogDTOMapper = Mockito.mock(DogDTOMapper.class);
        animalService = new AnimalService(catRepository,dogRepository,catDTOMapper,dogDTOMapper);
    }

    @Test
    void shouldFindAll(){
        //given
        //when
//        animalService
        //then
    }


}
