package com.mycompany.quizapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author EnricoBDev
 */
public class QuizScreen extends JFrame implements ActionListener {

    ArrayList<QuestionClass> questionsArray;

    JPanel pnlSubject, pnlQuiz, pnlQuestion, pnlAnswers;
    JLabel lblSubject, lblQuestion;
    JButton[] btnAnswersArray;

    TimedProgressBar progressBar;
    ThreadTimedProgressBar barThread;

    public QuizScreen(ArrayList<QuestionClass> questionsArray) {

        this.questionsArray = questionsArray;

        Collections.shuffle(questionsArray);
        // Collections.sort(questionsArray);

        this.setTitle("Quiz");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setSize(900, 400);

        this.createPanels();
        this.createProgressBar();
        this.createQuizComponents();
        this.addToPanels();
        this.addBarToFrame();
        this.addQuizToFrame();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        this.barThread = new ThreadTimedProgressBar(this, progressBar);
        this.barThread.start();

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

    private void createProgressBar() {
        this.progressBar = new TimedProgressBar();
    }

    private void createQuizComponents() {

        this.lblSubject = new JLabel(questionsArray.get(0).getSubject());
        this.lblQuestion = new JLabel(questionsArray.get(0).getQuestion());

        this.btnAnswersArray = new JButton[4];
        for (int i = 0; i < 4; i++) {
            this.btnAnswersArray[i] = new JButton(questionsArray.get(0).getAnswers()[i]);
            this.btnAnswersArray[i].setOpaque(false);
            this.btnAnswersArray[i].setBackground(Color.white);
            this.btnAnswersArray[i].addActionListener(this);
        }
    }

    private void addToPanels() {
        this.pnlSubject.add(this.lblSubject);
        this.pnlQuestion.add(this.lblQuestion);

        for (JButton i : btnAnswersArray) {
            this.pnlAnswers.add(i);
        }

        this.pnlQuiz.add(this.pnlSubject);
        this.pnlQuiz.add(this.pnlQuestion);
        this.pnlQuiz.add(this.pnlAnswers);
    }

    private void addBarToFrame() {
        this.add(progressBar);
    }

    private void addQuizToFrame() {
        this.add(pnlQuiz);
    }

    private void updateQuizUI() {
        // repaints the ui
        this.revalidate();
        this.repaint();

        this.lblSubject.setText(this.questionsArray.get(0).getSubject());
        this.lblQuestion.setText(this.questionsArray.get(0).getQuestion());

        for (int i = 0; i < 4; i++) {
            this.btnAnswersArray[i].setText(this.questionsArray.get(0).getAnswers()[i]);
            this.btnAnswersArray[i].setActionCommand(this.questionsArray.get(0).getAnswers()[i]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (questionsArray.size() > 1) {
            if (command.equals(this.questionsArray.get(0).getCorrectAnswer())) {
                this.barThread.settimeToEnd(0);
                this.progressBar.setValue(0); // resets the progress bar

                this.questionsArray.remove(0);
                this.updateQuizUI();
            } else {
                this.dispose();
                // TODO: insert what to show after game has ended
                JOptionPane.showMessageDialog(this, "Hai sbagliato, la risposta giusta è:\n" + this.questionsArray.get(0).getCorrectAnswer(), "Risposta sbagliata", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // TODO: insert what to show after game has ended
            JOptionPane.showMessageDialog(this, "Hai completato tutte le domande!", "Completazione", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
