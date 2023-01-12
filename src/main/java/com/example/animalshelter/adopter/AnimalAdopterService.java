package com.example.animalshelter.adopter;

import com.example.animalshelter.animal.Animal;
import com.example.animalshelter.animal.AnimalStatistics;
import com.example.animalshelter.animal.Cat;
import com.example.animalshelter.animal.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalAdopterService {

    private AnimalAdopterRepository animalAdopterRepository;
    private AnimalAdopterDTOMapper animalAdopterDTOMapper;

    public AnimalAdopterService(AnimalAdopterRepository animalAdopterRepository, AnimalAdopterDTOMapper animalAdopterDTOMapper) {
        this.animalAdopterRepository = animalAdopterRepository;
        this.animalAdopterDTOMapper = animalAdopterDTOMapper;
    }

    public List<AnimalAdopterDTO> findAll(){
        List<AnimalAdopter> animalAdopters = new ArrayList<>();
        animalAdopterRepository.findAll().forEach(animalAdopters::add);

        return animalAdopters.stream().map(animalAdopterDTOMapper::toDTO).toList();
    }

    public Optional<AnimalAdopterDTO> findByFirstNameDTO(String firstName){
        return animalAdopterRepository.findByFirstName(firstName).map(animalAdopterDTOMapper::toDTO);
    }

    public Optional<AnimalAdopter> findByFirstName(String firstName){
        return animalAdopterRepository.findByFirstName(firstName);
    }

    public Optional<AnimalAdopter> findById(Long adopterId){
        return animalAdopterRepository.findById(adopterId);
    }


    public void saveAnimalAdopter(AnimalAdopterDTO adopter){
        animalAdopterRepository.save(animalAdopterDTOMapper.toEntity(adopter));

    }

    public void addAdoptedAnimal(AnimalAdopter adopter, Animal animal){
                if(animal.getSpecies().equals(AnimalStatistics.Species.CAT)){
                    adopter.getAdoptedCats().add((Cat) animal);
                    animalAdopterRepository.save(adopter);
                }else {
                    adopter.getAdoptedDogs().add((Dog) animal);
                    animalAdopterRepository.save(adopter);
                }

    }


}
