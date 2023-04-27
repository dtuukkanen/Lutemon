package com.example.lutemon.LutemonHabitats;

import com.example.lutemon.Lutemons.Lutemon;
import com.example.lutemon.Storage;

import java.io.Serializable;

public class BattleField extends LutemonHabitat implements Serializable {
    public StringBuilder fight(Lutemon lutemon1, Lutemon lutemon2) {
        StringBuilder sb = new StringBuilder();
        sb.append("1: " + lutemon1.getName() + "  (" + lutemon1.getColor() + ") att: " + lutemon1.getAttack() + "; def: " + lutemon1.getDefence() + "; exp: " + lutemon1.getExperience()  + "; health: " + lutemon1.getHealth() + "/" + lutemon1.getMaxHealth() + "\n");
        sb.append("2: " + lutemon2.getName() + "  (" + lutemon2.getColor() + ") att: " + lutemon2.getAttack() + "; def: " + lutemon2.getDefence() + "; exp: " + lutemon2.getExperience()  + "; health: " + lutemon2.getHealth() + "/" + lutemon2.getMaxHealth() + "\n");


        while (true) {
            sb.append(lutemon2.getName() + " (" + lutemon2.getColor() + ") " + " hyökkää ja " + lutemon1.getName() + "(" + lutemon1.getColor() + ") puolustautuu hyökkäykseltä.\n");
            lutemon1.defense(lutemon2); //Lutemon2 attacks
            if (lutemon1.getHealth() <= 0) {
                sb.append(lutemon1.getName() + " (" + lutemon1.getColor() + ") kuoli haavoihinsa.\n");
                sb.append(lutemon2.getName() + " (" + lutemon2.getColor() + ")" + " voitti taistelun!\n");
                lutemon2.addExperience();
                Storage.getInstance().moveLutemon(Storage.Location.BATTLEFIELD, Storage.Location.DEAD, lutemon1);
                break;
            }

            sb.append(lutemon1.getName() + " (" + lutemon1.getColor() + ") " + " hyökkää ja " + lutemon2.getName() + "(" + lutemon2.getColor() + ") puolustautuu hyökkäykseltä.\n");
            lutemon2.defense(lutemon1); //Lutemon 1 attacks
            if (lutemon2.getHealth() <= 0) {
                sb.append(lutemon2.getName() + " (" + lutemon2.getColor() + ") kuoli haavoihinsa.\n");
                sb.append(lutemon1.getName() + " (" + lutemon1.getColor() + ")" + " voitti taistelun!\n");
                lutemon1.addExperience();
                Storage.getInstance().moveLutemon(Storage.Location.BATTLEFIELD, Storage.Location.DEAD, lutemon2);
                break;
            }
        }
        return sb;
    }
}