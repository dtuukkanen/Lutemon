package com.example.lutemon.LutemonHabitats;

import com.example.lutemon.Lutemons.Lutemon;

import java.io.Serializable;

public class Home extends LutemonHabitat implements Serializable {

    public void createLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }
}
