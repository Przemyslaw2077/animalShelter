package com.example.animalshelter.adopter;

import com.example.animalshelter.animal.Animal;
import com.example.animalshelter.animal.Cat;
import com.example.animalshelter.animal.Dog;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class AnimalAdopter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "owner")
    private List<Dog> adoptedDogs = new ArrayList<>();
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "owner")
    private Set<Cat> adoptedCats = new HashSet<>();

    public AnimalAdopter(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
    }

    public AnimalAdopter() {
    }
}
