package com.example.animalshelter;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dog extends Animal{

    @Enumerated(EnumType.STRING)
    private AnimalStatistics.DogsRace race;


    public Dog(String name, AnimalStatistics.Species species, AnimalStatistics.Gender gender, AnimalStatistics.Age age, AnimalStatistics.Size size, String description, AnimalStatistics.DogsRace race) {
        super(name, species, gender, age, size, description);
        this.race = race;
    }
}
