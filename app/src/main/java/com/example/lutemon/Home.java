package com.example.lutemon;

import java.util.ArrayList;

public class Home extends Storage{

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public ArrayList<Lutemon> listLutemons() {
        return lutemons;
    }

    public static void createLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }
}
