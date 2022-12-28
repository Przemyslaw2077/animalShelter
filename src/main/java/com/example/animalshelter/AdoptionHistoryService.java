package com.example.animalshelter;

import com.example.animalshelter.adopter.AnimalAdopter;
import com.example.animalshelter.adopter.AnimalAdopterService;
import com.example.animalshelter.animal.*;
import com.example.animalshelter.employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdoptionHistoryService {

    private AdoptionHistoryRepository adoptionHistoryRepository;
    private AnimalService animalService;
    private CatDTOMapper catDTOMapper;
    private DogDTOMapper dogDTOMapper;
    private AnimalAdopterService animalAdopterService;
    private EmployeeService employeeService;
    private AdoptionHistoryDTOMapper adoptionHistoryDTOMapper;

    public AdoptionHistoryService(AdoptionHistoryRepository adoptionHistoryRepository, AnimalService animalService, CatDTOMapper catDTOMapper, DogDTOMapper dogDTOMapper, AnimalAdopterService animalAdopterService, EmployeeService employeeService, AdoptionHistoryDTOMapper adoptionHistoryDTOMapper) {
        this.adoptionHistoryRepository = adoptionHistoryRepository;
        this.animalService = animalService;
        this.catDTOMapper = catDTOMapper;
        this.dogDTOMapper = dogDTOMapper;
        this.animalAdopterService = animalAdopterService;
        this.employeeService = employeeService;
        this.adoptionHistoryDTOMapper = adoptionHistoryDTOMapper;
    }

    @Transactional
    void saveAdoption(String employeeUserName, Long animalId, AnimalStatistics.Species animalSpecies, Long adopterId){
        AdoptionHistory adoptionHistory = new AdoptionHistory();

        AnimalDTO animal = animalService.findAnimalById(animalId, animalSpecies);
        Optional<AnimalAdopter> adopter = animalAdopterService.findById(adopterId);

        adopter.ifPresent(it -> {adoptionHistory.setAdopter(it); animalService.makeAnimalAdopted(animal, it);});

        if (animal.getSpecies().equals(AnimalStatistics.Species.CAT)){
            Cat cat = catDTOMapper.toEntity((CatDTO) animal);
            adoptionHistory.setAdoptedCat(cat);
            if (adopter.isPresent()) {
                animalAdopterService.addAdoptedAnimal(adopter.get(), cat);
            }

        }else {
            Dog dog = dogDTOMapper.toEntity((DogDTO) animal);
            adoptionHistory.setAdoptedDog(dog);
            if (adopter.isPresent()) {
                animalAdopterService.addAdoptedAnimal(adopter.get(), dog);
            }
        }


        Optional<Employee> employeeByUserName = employeeService.findEmployeeByUserName(employeeUserName);
            employeeByUserName.ifPresent(it -> adoptionHistory.setAnimalIssuingEmployee(it));
//        adoptionHistory.setAnimalIssuingEmployee(employeeService.findEmployeeByUserName());
        adoptionHistory.setAdoptDate(LocalDateTime.now());

        adoptionHistoryRepository.save(adoptionHistory);

    }

    List<AdoptionHistoryDTO> findAll(){
        List<AdoptionHistory> adoptionHistories = new ArrayList<>();

        adoptionHistoryRepository.findAll().forEach(adoptionHistories::add);

        return adoptionHistories.stream().map(adoptionHistoryDTOMapper::toDTO).toList();


    }
}
