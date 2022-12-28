package com.example.animalshelter.adopter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalAdopterRepository extends CrudRepository<AnimalAdopter, Long> {

    Optional<AnimalAdopter> findByFirstName(String firstName);
}
