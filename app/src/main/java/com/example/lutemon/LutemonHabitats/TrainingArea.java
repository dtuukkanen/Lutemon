package com.example.lutemon.LutemonHabitats;

import com.example.lutemon.Lutemons.Lutemon;

import java.util.LinkedHashMap;

public class TrainingArea extends LutemonHabitat {


    public void train(Lutemon lutemon) {
        lutemon.setExperience(lutemon.getExperience() + 1);
    }
}
