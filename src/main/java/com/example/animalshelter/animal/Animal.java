package com.example.animalshelter.animal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Animal {
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
    private boolean adopted;

}
