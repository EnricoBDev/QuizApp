package com.mycompany.quizapp;

import java.util.ArrayList;

/**
 *
 * @author EnricoBDev
 */
public class QuizApp {

    public static void main(String[] args) {
        
        ArrayList<PlayerClass> leaderboardArray = new ArrayList<>();
        
        PlayersFileReaderClass leaderboardReader = new PlayersFileReaderClass(leaderboardArray);
        leaderboardReader.readFromFile();
        
        HomeScreen homeScreen = new HomeScreen(leaderboardArray);

    }
}
