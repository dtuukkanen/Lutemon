package com.example.lutemon;

import java.util.ArrayList;

public class TrainingArea extends Storage{

    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    public static TrainingArea trainingArea = null;

    public TrainingArea(String name) {
        super("Harjoittelukenttä");
    }

    public static TrainingArea getInstance() {
        if (trainingArea == null) {
            trainingArea = new TrainingArea("Harjoittelukenttä");
        }
        return trainingArea;
    }

    public void train() {


    }

    @Override
    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
}
