package com.example.animalshelter.animal;


import com.example.animalshelter.adopter.AnimalAdopter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
public class AnimalDTO {

    private String name;
    private AnimalStatistics.Species species;
    private AnimalStatistics.Gender gender;
    private AnimalStatistics.Age age;
    private AnimalStatistics.Size size;
    private String description;
    private boolean adopted;
    private AnimalAdopter owner;


}
