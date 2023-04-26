package com.example.lutemon;

public class Home extends LutemonHabitat {

    public void createLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }
}
