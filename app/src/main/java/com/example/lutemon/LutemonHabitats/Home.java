package com.example.lutemon.LutemonHabitats;

import com.example.lutemon.Lutemons.Lutemon;

public class Home extends LutemonHabitat {

    public void createLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }
}
