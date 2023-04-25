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

    public void fight(){

    }

    @Override
    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
}
