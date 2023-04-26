package com.example.lutemon;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    private ArrayList<Lutemon> home = new ArrayList<>();
    private ArrayList<Lutemon> battlefield = new ArrayList<>();
    private ArrayList<Lutemon> training = new ArrayList<>();
    private static Storage storage = null;

    public Storage() {

    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Lutemon> getLutemons() {
        ArrayList<Lutemon> lutemons = new ArrayList<>();
        lutemons.addAll(home);
        lutemons.addAll(battlefield);
        lutemons.addAll(training);
        return lutemons;
    }

    public void moveLutemon(Location from, Location to, Lutemon lutemon) {
        switch (from) {
            case HOME:
                home.remove(lutemon);
                break;
            case TRAINING:
                training.remove(lutemon);
                break;
            case BATTLEFIELD:
                battlefield.remove(lutemon);
                break;
        }

        switch (to) {
            case HOME:
                home.add(lutemon);
                break;
            case TRAINING:
                training.add(lutemon);
                break;
            case BATTLEFIELD:
                battlefield.add(lutemon);
                break;
        }
    }

    public enum Location {
        HOME,
        TRAINING,
        BATTLEFIELD,
    }


    /*
    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream saveLutemon = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            saveLutemon.writeObject(lutemons);
            saveLutemon.close();
        } catch (IOException e) {
            System.out.println("Lutemonin tallentaminen epäonnistui.");
        }
    }

    public void loadLutemons(Context context) {
        try {
            ObjectInputStream loadLutemons = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemons = (ArrayList<Lutemon>) loadLutemons.readObject();
            loadLutemons.close();
        } catch (IOException e) {
            System.out.println("Lutemonien lataaminen epäonnistui.");
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lataaminen epäonnistui.");
        }
    }
    */

}
