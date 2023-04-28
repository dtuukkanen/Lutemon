package com.example.lutemon.Lutemons;

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
    private int image;

    public Lutemon(String name, String color, int attack, int defence, int experience, int health, int maxHealth, int id, int idCounter, int image) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.experience = 0;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.idCounter = idCounter;
        this.image = image;
    }

    public void defense(Lutemon lutemon) {
        health -= (lutemon.attack() - defence);
    }

    public int attack() {
        int damage = (int) ((attack + Math.random() * 3) + experience);
        return damage;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
    public int getAttack() {
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

    public int getImage() {
        return image;
    }

    public void addExperience() {
        this.experience += 1;
    }

    public void setHealth(int maxHealth) {
        health = maxHealth;
    }
}
