package com.example.animalshelter;

import com.example.animalshelter.adopter.*;
import com.example.animalshelter.animal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

public class AnimalAdopterServiceTest {

    private AnimalAdopterRepository animalAdopterRepositoryMOCK;
    private AnimalAdopterDTOMapper animalAdopterDTOMapperMOCK;
    private AnimalAdopter animalAdopterMOCK;
    private AnimalAdopterService animalAdopterService;

    @BeforeEach
    void init(){
        animalAdopterRepositoryMOCK = Mockito.mock(AnimalAdopterRepository.class);
        animalAdopterDTOMapperMOCK = Mockito.mock(AnimalAdopterDTOMapper.class);
        animalAdopterMOCK = Mockito.mock(AnimalAdopter.class);
        animalAdopterService = new AnimalAdopterService(animalAdopterRepositoryMOCK,animalAdopterDTOMapperMOCK);

    }


    @Test
    public void test(){
        //given

        AnimalAdopterDTO animalAdopterDTOMOCK = Mockito.mock(AnimalAdopterDTO.class);
        AnimalAdopter animalAdopterMOCK = Mockito.mock(AnimalAdopter.class);
        AnimalAdopterService animalAdopterServiceMOCK = Mockito.mock(AnimalAdopterService.class);
        Animal animalMOCK = Mockito.mock(Animal.class);

        AnimalAdopterService animalAdopterService = new AnimalAdopterService(animalAdopterRepositoryMOCK,animalAdopterDTOMapperMOCK);
        AnimalAdopter adopter = new AnimalAdopter("ddd","www","222");


        animalAdopterService.findByFirstName("Marcin");
        animalAdopterServiceMOCK.findByFirstName("Marcin");


        //when
        Optional<AnimalAdopter> qqqq = animalAdopterServiceMOCK.findByFirstName("Marcin");
//        animalAdopterServiceMOCK.create(animalAdopterDTOMOCK);
        //then
//        Assertions.assertEquals("dddd",qqqq.get().getFirstName());
        Mockito.verify(animalAdopterRepositoryMOCK).findByFirstName("Marcin");
    }

    @Test
    void shouldFindAllAdopters(){
        //given
        //when
        animalAdopterService.findAll();
        //then
        Mockito.verify(animalAdopterRepositoryMOCK).findAll();

    }



    @Test
    void shouldSaveAnimalAdopter(){
        //given
        AnimalAdopterDTO animalAdopterDTOMOCK = Mockito.mock(AnimalAdopterDTO.class);

        AnimalAdopter adopter = new AnimalAdopter();

        Mockito.when(animalAdopterRepositoryMOCK.save(animalAdopterMOCK)).thenReturn(adopter);


        //when
        animalAdopterService.saveAnimalAdopter(animalAdopterDTOMOCK);
        //then
        Mockito.verify(animalAdopterRepositoryMOCK).save(animalAdopterMOCK);



    }

    @Test
    void shouldAddAdoptedDog(){
        //given
        Animal dog = new Dog();
        dog.setSpecies(AnimalStatistics.Species.DOG);

        //when
        animalAdopterService.addAdoptedAnimal(animalAdopterMOCK, dog);
        //then
        Mockito.verify(animalAdopterMOCK).getAdoptedDogs();


    }
    @Test
    void shouldAddAdoptedCat(){
        //given
        Animal cat = new Cat();
        cat.setSpecies(AnimalStatistics.Species.CAT);

        //when
        animalAdopterService.addAdoptedAnimal(animalAdopterMOCK, cat);
        //then
        Mockito.verify(animalAdopterMOCK).getAdoptedCats();


    }


    @Test
    void shouldFindAdopterById(){
        //given

        //when
        animalAdopterService.findById(1L);
        //then
        Mockito.verify(animalAdopterRepositoryMOCK).findById(1L);



    }

    @Test
    void shouldFindAsllAdopters(){
        //given

        AnimalAdopter adopter1 = new AnimalAdopter("ddd1","www1","222");
        AnimalAdopter adopter2 = new AnimalAdopter("ddd2","www2","222");
        AnimalAdopter adopter3 = new AnimalAdopter("ddd3","www3","222");
        List<AnimalAdopter> ss = List.of(adopter1, adopter2, adopter3);

        //when
        //then
    }
}
