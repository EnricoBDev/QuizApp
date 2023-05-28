package com.mycompany.quizapp;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author EnricoBDev
 */
public class QuizScreen extends JFrame {

    TimedProgressBar progressBar;

    public QuizScreen() {

        this.setLayout(new GridLayout(2,1));
        
        // TODO: Create separate methods
        progressBar = new TimedProgressBar();
        this.add(progressBar);

        this.setLocationRelativeTo(null);
        this.setSize(400, 400);
        this.setVisible(true);

        ThreadTimedProgressBar barThread = new ThreadTimedProgressBar(progressBar);
        barThread.start();

    }

}
