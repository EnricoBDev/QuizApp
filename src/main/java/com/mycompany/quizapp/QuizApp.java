package com.mycompany.quizapp;

import java.util.ArrayList;

/**
 *
 * @author EnricoBDev
 */
public class QuizApp {

    public static void main(String[] args) {

        ArrayList<Object> leaderboardArray = new ArrayList<>();

        HomeScreen homeScreen = new HomeScreen(leaderboardArray);

    }
}
