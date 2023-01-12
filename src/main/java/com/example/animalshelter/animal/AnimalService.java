package com.example.animalshelter.animal;
import com.example.animalshelter.adopter.AnimalAdopter;
import com.example.animalshelter.animal.*;
import org.springframework.stereotype.Service;

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

    public List<AnimalDTO> findAllNoAdopted(){
        return findAll().stream().filter(it -> !it.isAdopted()).toList();
    }

    public List<AnimalDTO> findAllAdopted(){
        return findAll().stream().filter(it -> it.isAdopted()).toList();
    }



    public List<AnimalDTO> findAllBySpecies(AnimalStatistics.Species species){
        return findAllNoAdopted().stream().filter(it -> it.getSpecies().equals(species)).toList();
    }

    public List<AnimalDTO> findAllByGender(AnimalStatistics.Gender gender){
        return findAllNoAdopted().stream().filter(it -> it.getGender().equals(gender)).toList();
    }

    public AnimalDTO findAnimalById(Long id, AnimalStatistics.Species species) {
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

    public void deleteAnimal(Long id, AnimalStatistics.Species species){
        AnimalDTO animalToDelete = findAnimalById(id, species);
        if (animalToDelete.getSpecies().equals(AnimalStatistics.Species.CAT)){
            Cat cat = catDTOMapper.toEntity((CatDTO) animalToDelete);
            catRepository.delete(cat);
        }else {
            Dog dog = dogDTOMapper.toEntity((DogDTO) animalToDelete);

            dogRepository.delete(dog);
        }



    }


    public void makeAnimalAdopted( AnimalDTO animal, AnimalAdopter adopter){

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

    public void saveOrUpdateAnimal(AnimalDTO animalDTO, AnimalStatistics.CatRace catRace, AnimalStatistics.DogRace dogRace, Long animalToEditId){
        if (animalDTO.getSpecies().equals(AnimalStatistics.Species.CAT)){
            CatDTO catDTO = catDTOMapper.animalDTOToCatDTO(animalDTO);
            Cat cat = catDTOMapper.toEntity(catDTO);
            cat.setAdopted(false);
            cat.setRace(catRace);
            cat.setId(animalToEditId);
            catRepository.save(cat);
        }else {
            DogDTO dogDTO = dogDTOMapper.animalDTOToDogDTO(animalDTO);
            Dog dog = dogDTOMapper.toEntity(dogDTO);

            dog.setAdopted(false);
            dog.setRace(dogRace);
            dog.setId(animalToEditId);
            dogRepository.save(dog);
        }
    }
}
