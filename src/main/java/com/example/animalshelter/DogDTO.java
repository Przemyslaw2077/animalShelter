package com.example.animalshelter;

public class DogDTO extends AnimalDTO {
// description

    private AnimalStatistics.DogsRace race;


    public AnimalStatistics.DogsRace getRace() {
        return race;
    }

    public void setRace(AnimalStatistics.DogsRace race) {
        this.race = race;
    }
}
