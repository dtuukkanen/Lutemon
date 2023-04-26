package com.example.lutemon;

public class TrainingArea extends Storage{

    public static void train() {
        for (Lutemon lutemon : lutemons) {
            lutemon.experience += 1;
        }
    }
}
