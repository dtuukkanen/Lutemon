package com.example.lutemon;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {


    protected String name;
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();
    public Storage(String name) {
        this.name = name;
    }

    /*private static Storage storage = null;

    public Storage() {}

    public Storage(String name) {
        this.name = name;
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }*/

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public void listLutemons() {
        for (Lutemon lutemon : lutemons) {

        }
    }

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

}
