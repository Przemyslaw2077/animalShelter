package com.example.animalshelter.adoption_history;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionHistoryRepository extends CrudRepository<AdoptionHistory, Long> {



}
