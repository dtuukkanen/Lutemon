package com.example.lutemon;

import java.io.Serializable;

public class Lutemon implements Serializable {

    protected String name;
    protected String color;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    private int idCounter;

    public Lutemon(String name, String color, int attack, int defence, int experience, int health, int maxHealth, int id, int idCounter) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.experience = 0;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.idCounter = idCounter;
    }

    public void defense(Lutemon lutemon) {
        health -= (defence - lutemon.getAttack());
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        attack = attack + experience;
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
