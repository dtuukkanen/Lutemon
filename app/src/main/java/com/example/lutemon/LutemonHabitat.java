package com.example.lutemon;

import java.util.ArrayList;

public abstract class LutemonHabitat {
    protected static ArrayList<Lutemon> lutemons = new ArrayList<>();

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }

    public static ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
}
