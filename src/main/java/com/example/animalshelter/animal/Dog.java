package com.example.animalshelter.animal;

import com.example.animalshelter.adopter.AnimalAdopter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dog extends Animal {

    @Enumerated(EnumType.STRING)
    private AnimalStatistics.DogRace race;

    @ManyToOne
    @JoinColumn(name = "animal_adopter_id")
    private AnimalAdopter owner;


}
