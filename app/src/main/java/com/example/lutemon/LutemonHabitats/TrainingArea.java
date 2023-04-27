package com.example.lutemon.LutemonHabitats;

import com.example.lutemon.Lutemons.Lutemon;

public class TrainingArea extends LutemonHabitat {

    public void train() {
        for (Lutemon lutemon : lutemons) {
            lutemon.addExperience();
        }
    }
}
