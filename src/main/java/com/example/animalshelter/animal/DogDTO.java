package com.example.animalshelter.animal;

public class DogDTO extends AnimalDTO {
// description

    private Long id;
    private AnimalStatistics.DogRace race;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnimalStatistics.DogRace getRace() {
        return race;
    }

    public void setRace(AnimalStatistics.DogRace race) {
        this.race = race;
    }
}
