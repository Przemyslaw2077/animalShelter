package com.example.animalshelter.animal;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DogRepository extends CrudRepository<Dog, Long> {

    List<Dog> findAll();

    Optional<Dog> findByName(String name);

}
