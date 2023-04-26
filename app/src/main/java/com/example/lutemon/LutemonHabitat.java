package com.example.lutemon;

import java.util.ArrayList;

public abstract class LutemonHabitat {
    protected static ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static LutemonHabitat habitat = null;

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
