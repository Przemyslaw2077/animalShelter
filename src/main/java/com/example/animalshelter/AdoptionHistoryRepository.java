package com.example.animalshelter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionHistoryRepository extends CrudRepository<AdoptionHistory, Long> {



}
