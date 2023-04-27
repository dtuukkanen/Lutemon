package com.example.lutemon.LutemonHabitats;

import com.example.lutemon.Lutemons.Lutemon;

import java.io.Serializable;

public class BattleField extends LutemonHabitat implements Serializable {
    public void fight(Lutemon lutemon1, Lutemon lutemon2) {
        int i = 1;
        while (true) {
            if (lutemon1.getHealth() <= 0) {
                System.out.println("Lutemon2 voitti");
            } else if (lutemon2.getHealth() <= 0) {
                System.out.println("Lutemon1 voitti");
            }
            if (i % 2 == 0) {
                lutemon1.defense(lutemon2); //Lutemon2 attacks
            } else {
                lutemon2.defense(lutemon1); //Lutemon 1 attacks
            }
        }
    }
}