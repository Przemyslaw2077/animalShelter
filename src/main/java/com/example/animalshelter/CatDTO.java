package com.example.animalshelter;

public class CatDTO extends AnimalDTO {


    private AnimalStatistics.CatRace race;

    public AnimalStatistics.CatRace getRace() {
        return race;
    }

    public void setRace(AnimalStatistics.CatRace race) {
        this.race = race;
    }

}
