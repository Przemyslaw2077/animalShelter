package com.example.animalshelter.animal;

public class CatDTO extends AnimalDTO {


    private Long id;
    private AnimalStatistics.CatRace race;

    public AnimalStatistics.CatRace getRace() {
        return race;
    }

    public void setRace(AnimalStatistics.CatRace race) {
        this.race = race;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
