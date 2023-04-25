package com.example.lutemon;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    protected static Storage storage = null;
    protected String name;
    private ArrayList<Lutemon> lutemonsAtHome = new ArrayList<>();
    private ArrayList<Lutemon> lutemonsAtTraining = new ArrayList<>();
    private ArrayList<Lutemon> lutemonsAtBattle = new ArrayList<>();
    private ArrayList<Lutemon> lutemonsAtDead = new ArrayList<>();
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private ArrayList<ArrayList<Lutemon>> lutemonListsForSaving = new ArrayList<>();


    private Storage() {}
    public static Storage GetInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Lutemon> getLutemonsAtHome() {
        return lutemonsAtHome;
    }

    public ArrayList<Lutemon> getLutemonsAtTraining() {
        return lutemonsAtTraining;
    }

    public ArrayList<Lutemon> getLutemonsAtBattle() {
        return lutemonsAtBattle;
    }

    public ArrayList<Lutemon> getLutemonsAtDead() {
        return lutemonsAtDead;
    }

    public ArrayList<Lutemon> getLutemons() {
        lutemons.clear();
        lutemons.addAll(lutemonsAtHome);
        lutemons.addAll(lutemonsAtTraining);
        lutemons.addAll(lutemonsAtBattle);
        lutemons.addAll(lutemonsAtDead);
        return lutemons;
    }
    public ArrayList<ArrayList<Lutemon>> getLutemonListsForSaving() {
        lutemonListsForSaving.clear();
        lutemonListsForSaving.add(lutemonsAtHome);
        lutemonListsForSaving.add(lutemonsAtTraining);
        lutemonListsForSaving.add(lutemonsAtBattle);
        lutemonListsForSaving.add(lutemonsAtDead);
        return lutemonListsForSaving;
    }
    public void addLutemon(Lutemon lutemon) {
        lutemonsAtHome.add(lutemon);
    }

    public void moveLutemon(ArrayList<Lutemon> fromList, Lutemon lutemon, ArrayList<Lutemon> toList) {
        fromList.remove(lutemon);
        toList.add(lutemon);
    }


    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream saveLutemons = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            saveLutemons.writeObject(Storage.GetInstance().getLutemonListsForSaving());
            System.out.println("Lutemonit tallennettu.");
            saveLutemons.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen epäonnistui.");
        }
    }

    public void loadLutemons(Context context) {
        try {
            ObjectInputStream loadLutemons = new ObjectInputStream(context.openFileInput("lutemons.data"));
            Storage.GetInstance().lutemonListsForSaving = (ArrayList<ArrayList<Lutemon>>) loadLutemons.readObject();
            loadLutemons.close();
        } catch (FileNotFoundException e) {
            System.out.println("Datatiedostoa ei löytynyt.");
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
