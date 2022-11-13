package com.example.animalshelter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cat extends Animal{
// cat
    @Enumerated(EnumType.STRING)
    private AnimalStatistics.CatRace race;

    public Cat(String name, AnimalStatistics.Species species, AnimalStatistics.Gender gender, AnimalStatistics.Age age, AnimalStatistics.Size size, String description, AnimalStatistics.CatRace race) {
        super(name, species, gender, age, size, description);
        this.race = race;
    }

}
