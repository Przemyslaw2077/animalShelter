package com.example.animalshelter.animal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

    List<Cat> findAll();


    Optional<Cat> findByName(String name);
}
