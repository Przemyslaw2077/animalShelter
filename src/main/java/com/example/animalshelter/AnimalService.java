package com.example.animalshelter;
import com.example.animalshelter.adopter.AnimalAdopter;
import com.example.animalshelter.animal.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    private List<AnimalDTO> findAll(){
        List<AnimalDTO> animals = new ArrayList<>();

        List<CatDTO> catDTOS = catRepository.findAll().stream().map(catDTOMapper::toDTO).toList();
        List<DogDTO> dogDTOS = dogRepository.findAll().stream().map(dogDTOMapper::toDTO).toList();

        animals.addAll(catDTOS);
        animals.addAll(dogDTOS);

        return animals;
    }

    List<AnimalDTO> findAllNoAdopted(){
        return findAll().stream().filter(it -> !it.isAdopted()).toList();
    }

    List<AnimalDTO> findAllAdopted(){
        return findAll().stream().filter(it -> it.isAdopted()).toList();
    }



    List<AnimalDTO> findAllBySpecies(AnimalStatistics.Species species){
        return findAllNoAdopted().stream().filter(it -> it.getSpecies().equals(species)).toList();
    }

    List<AnimalDTO> findAllByGender(AnimalStatistics.Gender gender){
        return findAllNoAdopted().stream().filter(it -> it.getGender().equals(gender)).toList();
    }

    AnimalDTO findAnimalByName(String name, AnimalStatistics.Species species) {
        Optional<Cat> cat = catRepository.findByName(name);
        Optional<Dog> dog = dogRepository.findByName(name);

        AnimalDTO animal = new AnimalDTO();
        if (species.equals(AnimalStatistics.Species.CAT)) {
            if (cat.isPresent())
                animal = catDTOMapper.toDTO(cat.get());
        } else{
            if (dog.isPresent())
                animal = dogDTOMapper.toDTO(dog.get());
        }
        return animal;
    }

    AnimalDTO findAnimalById(Long id, AnimalStatistics.Species species) {
        Optional<Cat> cat = catRepository.findById(id);
        Optional<Dog> dog = dogRepository.findById(id);


        AnimalDTO animal = new AnimalDTO();
        if (species.equals(AnimalStatistics.Species.CAT)) {
            if (cat.isPresent())
                animal = catDTOMapper.toDTO(cat.get());
        } else{
            if (dog.isPresent())
                animal = dogDTOMapper.toDTO(dog.get());
        }
        return animal;
    }


    void makeAnimalAdopted( AnimalDTO animal, AnimalAdopter adopter){


//        animal.setOwner(adopter);
//        animal.setAdopted(true);

        if (animal.getSpecies().equals(AnimalStatistics.Species.CAT)){
            Cat cat = catDTOMapper.toEntity((CatDTO) animal);
            cat.setOwner(adopter);
            cat.setAdopted(true);
            catRepository.save(cat);
        }else {
            Dog dog = dogDTOMapper.toEntity((DogDTO) animal);
            dog.setOwner(adopter);
            dog.setAdopted(true);
            dogRepository.save(dog);
        }
    }

    void saveAnimal(AnimalDTO animalDTO, AnimalStatistics.CatRace catRace, AnimalStatistics.DogRace dogRace){
        if (animalDTO.getSpecies().equals(AnimalStatistics.Species.CAT)){
            CatDTO catDTO = catDTOMapper.animalDTOToCatDTO(animalDTO);
            Cat cat = catDTOMapper.toEntity(catDTO);
            cat.setAdopted(false);
            cat.setRace(catRace);
            catRepository.save(cat);
        }else {
            DogDTO dogDTO = dogDTOMapper.animalDTOToDogDTO(animalDTO);
            Dog dog = dogDTOMapper.toEntity(dogDTO);

            dog.setAdopted(false);
            dog.setRace(dogRace);
            dogRepository.save(dog);
        }
    }
}
