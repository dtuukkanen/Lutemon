package com.example.lutemon;

import java.util.ArrayList;

public class Home extends Storage{


    public static Home home = null;


    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    public Home(String name) {
        super("Koti");
    }

    public static Home getInstance() {
        if (home == null) {
            home = new Home("Koti");
        }
        return home;
    }

    public void createLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

}
