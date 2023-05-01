package com.example.lutemon.LutemonHabitats;

import com.example.lutemon.Lutemons.Lutemon;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class LutemonHabitat implements Serializable { // Abstract class to be extended by classes for different habitats
    protected ArrayList<Lutemon> lutemons = new ArrayList<>(); // A list to be used to store lutemons in subclasses

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
}
