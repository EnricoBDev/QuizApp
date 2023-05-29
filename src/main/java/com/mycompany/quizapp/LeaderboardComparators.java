package com.mycompany.quizapp;

/**
 *
 * @author andre
 */
import java.util.*;

public abstract class LeaderboardComparators implements Comparator<PlayerClass> {

    public static class CompareLevel implements Comparator<PlayerClass> {

        @Override
        public int compare(PlayerClass player1, PlayerClass player2) {
            int result;
            result = player1.getLevel() - player2.getLevel();
            if(result == 0){
                result = player1.getScore() - player2.getScore();
                if(result == 0){
                    result = player1.getUsername().compareTo(player2.getUsername());
                }
            }
            return result;
        }
    }

    public static class CompareScore implements Comparator<PlayerClass> {

        @Override
        public int compare(PlayerClass player1, PlayerClass player2) {
            int result;
            result = player1.getScore() - player2.getScore();
            if(result == 0){
                result = player1.getLevel() - player2.getLevel();
                if(result == 0){
                    result = player1.getUsername().compareTo(player2.getUsername());
                }
            }
            return result;
        }
    }

    public static class CompareUsername implements Comparator<PlayerClass> {

        @Override
        public int compare(PlayerClass player1, PlayerClass player2) {
            int result;
            result = player1.getUsername().compareTo(player2.getUsername());
            if(result == 0){
                result = player1.getLevel() - player2.getLevel();
                if(result == 0){
                    result = player1.getScore() - player2.getScore();
                }
            }
            return result;
        }
    }
}
