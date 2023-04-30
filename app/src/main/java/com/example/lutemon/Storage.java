package com.example.lutemon;

import android.content.Context;

import com.example.lutemon.LutemonHabitats.BattleField;
import com.example.lutemon.LutemonHabitats.Dead;
import com.example.lutemon.LutemonHabitats.Home;
import com.example.lutemon.LutemonHabitats.TrainingArea;
import com.example.lutemon.Lutemons.Lutemon;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    private Home home = new Home();
    private BattleField battlefield = new BattleField();
    private TrainingArea training = new TrainingArea();
    private Dead dead = new Dead();
    private static Storage storage = null;

    public Storage() {

    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
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

    public Dead getDead() {
        return dead;
    }

    public ArrayList<Lutemon> getLutemons() {
        ArrayList<Lutemon> lutemons = new ArrayList<>();
        lutemons.addAll(Storage.getInstance().getHome().getLutemons());
        lutemons.addAll(Storage.getInstance().getBattlefield().getLutemons());
        lutemons.addAll(Storage.getInstance().getTraining().getLutemons());
        lutemons.addAll(Storage.getInstance().getDead().getLutemons());
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
            case DEAD:
                dead.addLutemon(lutemon);
        }
    }

    public enum Location {
        HOME,
        TRAINING,
        BATTLEFIELD,
        DEAD,
    }

    public void saveLutemons(Context context) {
        try {
            // Save home
            ObjectOutputStream saveLutemonHome = new ObjectOutputStream(context.openFileOutput("LutemonsHome.data", Context.MODE_PRIVATE));
            saveLutemonHome.writeObject(Storage.getInstance().getHome());
            saveLutemonHome.close();
            // Save training
            ObjectOutputStream saveLutemonTraining = new ObjectOutputStream(context.openFileOutput("LutemonsTraining.data", Context.MODE_PRIVATE));
            saveLutemonTraining.writeObject(Storage.getInstance().getTraining());
            saveLutemonTraining.close();
            // Save battlefield
            ObjectOutputStream saveLutemonBattlefield = new ObjectOutputStream(context.openFileOutput("LutemonsBattlefield.data", Context.MODE_PRIVATE));
            saveLutemonBattlefield.writeObject(Storage.getInstance().getBattlefield());
            saveLutemonBattlefield.close();
            //Save dead
            ObjectOutputStream saveLutemonDead = new ObjectOutputStream(context.openFileOutput("LutemonsDead.data", Context.MODE_PRIVATE));
            saveLutemonDead.writeObject(Storage.getInstance().getDead());
            saveLutemonDead.close();
        } catch (IOException e) {
            System.out.println("Lutemonin tallentaminen epäonnistui.");
            e.printStackTrace();
        }
    }

    public void loadLutemons(Context context) {
        try {
            // Load home
            ObjectInputStream loadLutemonsHome = new ObjectInputStream(context.openFileInput("LutemonsHome.data"));
            home = (Home) loadLutemonsHome.readObject();
            loadLutemonsHome.close();
            // Load training
            ObjectInputStream loadLutemonsTraining = new ObjectInputStream(context.openFileInput("LutemonsTraining.data"));
            training = (TrainingArea) loadLutemonsTraining.readObject();
            loadLutemonsTraining.close();
            // Load battlefield
            ObjectInputStream loadLutemonsBattlefield = new ObjectInputStream(context.openFileInput("LutemonsBattlefield.data"));
            battlefield = (BattleField) loadLutemonsBattlefield.readObject();
            loadLutemonsBattlefield.close();
            // Load dead
            ObjectInputStream loadLutemonsDead = new ObjectInputStream(context.openFileInput("LutemonsDead.data"));
            dead = (Dead) loadLutemonsBattlefield.readObject();
            loadLutemonsDead.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ei löydetty ladattavia Lutemoneja");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Lutemonien lataaminen epäonnistui.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lataaminen epäonnistui.");
            e.printStackTrace();
        }
    }


}
