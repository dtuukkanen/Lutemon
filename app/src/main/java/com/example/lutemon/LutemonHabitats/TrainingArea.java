package com.example.lutemon.LutemonHabitats;

import com.example.lutemon.Lutemons.Lutemon;

public class TrainingArea extends LutemonHabitat { // A class for storing lutemons in training and training them

    public void train() { // gives all lutemons in training +1 experience
        for (Lutemon lutemon : lutemons) {
            lutemon.addExperience();
            lutemon.addTrainingDays();
        }
    }
}
