package com.example.myapplication4;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Fitness implements Serializable {

    //Declare variables

    @Exclude
    private String key;
    private String date;
    private String forearms;
    private String biceps;
    private String triceps;
    private String upper_chest;
    private String lower_chest;
    private String both;
    private String squat;
    private String leg_press;
    private String running_machine;

    public Fitness(){

    }

    // generate constructor

    public Fitness(String date, String forearms, String biceps, String triceps, String upper_chest, String lower_chest, String both, String squat, String leg_press, String running_machine) {
        this.date = date;
        this.forearms = forearms;
        this.biceps = biceps;
        this.triceps = triceps;
        this.upper_chest = upper_chest;
        this.lower_chest = lower_chest;
        this.both = both;
        this.squat = squat;
        this.leg_press = leg_press;
        this.running_machine = running_machine;
    }

    // Getters and setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getForearms() {
        return forearms;
    }

    public void setForearms(String forearms) {
        this.forearms = forearms;
    }

    public String getBiceps() {
        return biceps;
    }

    public void setBiceps(String biceps) {
        this.biceps = biceps;
    }

    public String getTriceps() {
        return triceps;
    }

    public void setTriceps(String triceps) {
        this.triceps = triceps;
    }

    public String getUpper_chest() {
        return upper_chest;
    }

    public void setUpper_chest(String upper_chest) {
        this.upper_chest = upper_chest;
    }

    public String getLower_chest() {
        return lower_chest;
    }

    public void setLower_chest(String lower_chest) {
        this.lower_chest = lower_chest;
    }

    public String getBoth() {
        return both;
    }

    public void setBoth(String both) {
        this.both = both;
    }

    public String getSquat() {
        return squat;
    }

    public void setSquat(String squat) {
        this.squat = squat;
    }

    public String getLeg_press() {
        return leg_press;
    }

    public void setLeg_press(String leg_press) {
        this.leg_press = leg_press;
    }

    public String getRunning_machine() {
        return running_machine;
    }

    public void setRunning_machine(String running_machine) {
        this.running_machine = running_machine;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
