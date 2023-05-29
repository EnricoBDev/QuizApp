package com.mycompany.quizapp;

import java.io.Serializable;

/**
 * Model class for the player
 *
 * @author zotta
 */
public class PlayerClass implements Serializable{

    private String username;
    private String image;
    private int level;
    private int score;

    //constructor method
    public PlayerClass(String username, String image, int level, int score) {
        this.username = username;
        this.image = image;
        this.level = level;
        this.score = score;
    }

    //getter methods
    public String getImage() {
        return image;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public String getUsername() {
        return username;
    }

    //setter method
    public void setImage(String image) {
        this.image = image;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Username: " + this.username + " pts: " + this.score;
    }

}
