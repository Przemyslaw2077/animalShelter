package com.example.animalshelter;


import com.example.animalshelter.adopter.AnimalAdopter;
import com.example.animalshelter.animal.Cat;
import com.example.animalshelter.animal.Dog;
import com.example.animalshelter.employee.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class AdoptionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee animalIssuingEmployee;
    @OneToOne
    @JoinColumn(name = "cat_id")
    private Cat adoptedCat;
    @JoinColumn(name = "dog_id")
    @OneToOne
    private Dog adoptedDog;
    @ManyToOne
    @JoinColumn(name = "adopter_id")
    private AnimalAdopter adopter;
    private LocalDateTime adoptDate;

    public AdoptionHistory() {
    }
}
