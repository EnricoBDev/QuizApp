package com.mycompany.quizapp;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Andre
 */
public class LeaderboardList extends JList<PlayerClass>{

    private ArrayList<PlayerClass> leaderboardArray;

    public LeaderboardList(ArrayList<PlayerClass> leaderboardArray) {
        this.leaderboardArray = leaderboardArray;
        this.populateList();
    }
    
    
    public void populateList(){
        DefaultListModel<PlayerClass> listModel = new DefaultListModel<>();
        Collections.sort(leaderboardArray, new LeaderboardComparators.CompareScore());
        listModel.addAll(leaderboardArray);
        this.setModel(listModel);
    }
}
