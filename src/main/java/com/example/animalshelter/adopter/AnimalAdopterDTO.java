package com.example.animalshelter.adopter;

import com.example.animalshelter.animal.Cat;
import com.example.animalshelter.animal.Dog;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class AnimalAdopterDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private List<Dog> adoptedDogs;
    private Set<Cat> adoptedCats;
}
