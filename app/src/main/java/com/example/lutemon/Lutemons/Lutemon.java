package com.example.lutemon.Lutemons;

import java.io.Serializable;

public class Lutemon implements Serializable {

    protected String name;
    protected String color;
    protected String status;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int wins;
    protected int battles;
    protected int trainingDays;
    //private int idCounter;
    private int image;

    public Lutemon(String name, String color, String status, int attack, int defence, int experience, int health, int maxHealth, int id, int wins, int battles, int trainingDays, int image) {
        this.name = name;
        this.color = color;
        this.status = status;
        this.attack = attack;
        this.defence = defence;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.wins = wins;
        this.battles = battles;
        this.trainingDays = trainingDays;
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
    public String getStatus() {
        return status;
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
    public int getWins() {
        return wins;
    }

    public int getBattles() {
        return battles;
    }

    public int getTrainingDays() {
        return trainingDays;
    }

    public void addExperience() {
        this.experience += 1;
    }

    public void setHealth(int maxHealth) {
        health = maxHealth;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addWin() {
        this.wins += 1;
    }

    public void addBattles() {
        this.battles += 1;
    }

    public void addTrainingDays() {
        this.trainingDays += 1;
    }
}
