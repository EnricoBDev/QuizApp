package com.mycompany.quizapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EnricoBDev
 */
public class QuizScreen extends JFrame {

    ArrayList<QuestionClass> questionsArray;

    JPanel pnlSubject, pnlQuiz, pnlQuestion, pnlAnswers;
    JLabel lblSubject, lblQuestion;
    JButton[] btnAnswersArray;

    TimedProgressBar progressBar;

    public QuizScreen(ArrayList<QuestionClass> questionsArray) {

        this.questionsArray = questionsArray;
        
        Collections.shuffle(questionsArray);
        Collections.sort(questionsArray);

        this.setTitle("Quiz");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setSize(900, 400);

        this.createPanels();
        this.createComponents();
        this.addToPanels();
        this.addListeners();
        this.addToFrame();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        ThreadTimedProgressBar barThread = new ThreadTimedProgressBar(progressBar);
        barThread.start();

    }

    private void createPanels() {
        this.pnlSubject = new JPanel();
        this.pnlQuiz = new JPanel();
        this.pnlQuestion = new JPanel();
        this.pnlAnswers = new JPanel();

        this.pnlSubject.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.pnlQuiz.setLayout(new BoxLayout(this.pnlQuiz, BoxLayout.Y_AXIS));
        this.pnlQuestion.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.pnlAnswers.setLayout(new GridLayout(2, 2));
    }

    private void createComponents() {
        this.progressBar = new TimedProgressBar();
        
        this.lblSubject = new JLabel(questionsArray.get(0).getSubject().toUpperCase());
        this.lblQuestion = new JLabel(questionsArray.get(0).getQuestion());
        
        this.btnAnswersArray = new JButton[4];
        for(int i = 0; i < 4; i++){
            this.btnAnswersArray[i] = new JButton(questionsArray.get(0).getAnswers()[i]);
            this.btnAnswersArray[i].setOpaque(false);
            this.btnAnswersArray[i].setBackground(Color.white);
        }
    }

    private void addToPanels() {
        this.pnlSubject.add(this.lblSubject);
        this.pnlQuestion.add(this.lblQuestion);
        
        for(JButton i : btnAnswersArray){
            this.pnlAnswers.add(i);
        }
        
        this.pnlQuiz.add(this.pnlSubject);
        this.pnlQuiz.add(this.pnlQuestion);
        this.pnlQuiz.add(this.pnlAnswers);
    }

    private void addListeners() {
    }

    private void addToFrame() {
        this.add(progressBar);
        this.add(pnlQuiz);
    }
}
