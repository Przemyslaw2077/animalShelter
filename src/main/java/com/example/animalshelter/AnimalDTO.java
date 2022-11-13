package com.example.animalshelter;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDTO {

    private String name;
    private AnimalStatistics.Species species;
    private AnimalStatistics.Gender gender;
    private AnimalStatistics.Age age;
    private AnimalStatistics.Size size;
    private String description;


}
