package com.example.lutemon;

import android.content.Context;

import com.example.lutemon.LutemonHabitats.BattleField;
import com.example.lutemon.LutemonHabitats.Home;
import com.example.lutemon.LutemonHabitats.TrainingArea;
import com.example.lutemon.Lutemons.Lutemon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    private Home home = new Home();
    private BattleField battlefield = new BattleField();
    private TrainingArea training = new TrainingArea();
    private static Storage storage = null;

    public Storage() {

    }

    public Home getHome() {
        return home;
    }

    public BattleField getBattlefield() {
        return battlefield;
    }

    public TrainingArea getTraining() {
        return training;
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Lutemon> getLutemons() {
        ArrayList<Lutemon> lutemons = new ArrayList<>();
        lutemons.addAll(Storage.getInstance().getHome().getLutemons());
        lutemons.addAll(Storage.getInstance().getBattlefield().getLutemons());
        lutemons.addAll(Storage.getInstance().getTraining().getLutemons());
        return lutemons;
    }

    public void moveLutemon(Location from, Location to, Lutemon lutemon) {
        switch (from) {
            case HOME:
                home.removeLutemon(lutemon);
                break;
            case TRAINING:
                training.removeLutemon(lutemon);
                break;
            case BATTLEFIELD:
                battlefield.removeLutemon(lutemon);
                break;
        }

        switch (to) {
            case HOME:
                home.addLutemon(lutemon);
                break;
            case TRAINING:
                training.addLutemon(lutemon);
                break;
            case BATTLEFIELD:
                battlefield.addLutemon(lutemon);
                break;
        }
    }

    public enum Location {
        HOME,
        TRAINING,
        BATTLEFIELD,
    }

    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream saveLutemonHome = new ObjectOutputStream(context.openFileOutput("LutemonsHome.data", Context.MODE_PRIVATE));
            saveLutemonHome.writeObject(Storage.getInstance().getHome());
            saveLutemonHome.close();
            ObjectOutputStream saveLutemonTraining = new ObjectOutputStream(context.openFileOutput("LutemonsTraining.data", Context.MODE_PRIVATE));
            saveLutemonTraining.writeObject(Storage.getInstance().getTraining());
            saveLutemonTraining.close();
            ObjectOutputStream saveLutemonBattlefield = new ObjectOutputStream(context.openFileOutput("LutemonsBattlefield.data", Context.MODE_PRIVATE));
            saveLutemonBattlefield.writeObject(Storage.getInstance().getBattlefield());
            saveLutemonBattlefield.close();
        } catch (IOException e) {
            System.out.println("Lutemonin tallentaminen epäonnistui.");
        }
    }

    public void loadLutemons(Context context) {
        try {
            ObjectInputStream loadLutemonsHome = new ObjectInputStream(context.openFileInput("LutemonsHome.data"));
            home = (Home) loadLutemonsHome.readObject();
            loadLutemonsHome.close();
            ObjectInputStream loadLutemonsTraining = new ObjectInputStream(context.openFileInput("LutemonsTraining.data"));
            training = (TrainingArea) loadLutemonsTraining.readObject();
            loadLutemonsTraining.close();
            ObjectInputStream loadLutemonsBattlefield = new ObjectInputStream(context.openFileInput("LutemonsBattlefield.data"));
            battlefield = (BattleField) loadLutemonsBattlefield.readObject();
            loadLutemonsBattlefield.close();
        } catch (IOException e) {
            System.out.println("Lutemonien lataaminen epäonnistui.");
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lataaminen epäonnistui.");
        }
    }


}
