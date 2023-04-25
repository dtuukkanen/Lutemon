package com.example.lutemon;

import java.util.ArrayList;

public class BattleField extends Storage{

    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    public static BattleField battleField = null;

    public BattleField(String name) {
        super("Taistelukenttä");
    }

    public static BattleField getInstance() {
        if (battleField == null) {
            battleField = new BattleField("Taistelukenttä");
        }
        return battleField;
    }

    public void fight(int firstId, int secondID){

        Lutemon lutemonOne = lutemons.get(firstId);
        Lutemon lutemonTwo = lutemons.get(secondID);

        System.out.println("1: " + lutemonOne.name + " (" + lutemonOne.color + ") att: " + lutemonOne.attack + "; def: " + lutemonOne.defence + "; exp: " + lutemonOne.experience + "; exp: " + lutemonOne.experience + "; health: " + lutemonOne.health + "/" + lutemonOne.maxHealth);
        System.out.println("2: " + lutemonTwo.name + " (" + lutemonTwo.color + ") att: " + lutemonTwo.attack + "; def: " + lutemonTwo.defence + "; exp: " + lutemonTwo.experience + "; exp: " + lutemonTwo.experience + "; health: " + lutemonTwo.health + "/" + lutemonTwo.maxHealth);
        //StringBuilder sb = new StringBuilder();

        while (lutemonOne.health > 0 && lutemonTwo.health > 0) {
            System.out.println(lutemonOne.name + "(" + lutemonOne.color + ") " + " hyökkää ja" + lutemonTwo.name + "(" + lutemonTwo.color + ") puolustautuu hyökkäykseltä.");
            lutemonTwo.defense(lutemonOne);

            System.out.println(lutemonTwo.name + "(" + lutemonTwo.color + ") " + " hyökkää ja" + lutemonOne.name + "(" + lutemonOne.color + ") puolustautuu hyökkäykseltä.");
            lutemonOne.defense(lutemonTwo);

        }

        if (lutemonOne.health < 0) {
            System.out.println(lutemonOne.name + " (" + lutemonOne.color + ") kuoli haavoihinsa.");
            System.out.println(lutemonTwo + " voitti taistelun!");
        }
        else if (lutemonTwo.health < 0) {
            System.out.println(lutemonTwo.name + " (" + lutemonTwo.color + ") kuoli haavoihinsa.");
            System.out.println(lutemonOne + " voitti taistelun!");
        }


    }

    @Override
    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
}
