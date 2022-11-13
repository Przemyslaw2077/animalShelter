package com.example.animalshelter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AnimalStatistics.Species species;
    @Enumerated(EnumType.STRING)
    private AnimalStatistics.Gender gender;
    @Enumerated(EnumType.STRING)
    private AnimalStatistics.Age age;
    @Enumerated(EnumType.STRING)
    private AnimalStatistics.Size size;
    private String description;

    public Animal(String name, AnimalStatistics.Species species, AnimalStatistics.Gender gender, AnimalStatistics.Age age, AnimalStatistics.Size size, String description) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.age = age;
        this.size = size;
        this.description = description;
    }

}
