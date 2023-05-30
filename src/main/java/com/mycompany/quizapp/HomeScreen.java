package com.mycompany.quizapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Home Screen window
 *
 * @author Felice
 */
public class HomeScreen extends JFrame implements ActionListener {

    private PlayersFileReaderClass leaderboardReader;
    private QuestionFileReaderClass questionReader;

    private ArrayList<PlayerClass> leaderboardArray;
    private ArrayList<QuestionClass> questionsArray;

    private LeaderboardList leaderboardList;

    private JButton btnPlay, btnExit, btnOptions, btnProfile;
    private JLabel lblLeaderboard, lblAvatar, lblLogo;

    private JPanel pnlNord, pnlCenter, pnlSud, pnlEast, pnlWest, pnlPlay, pnlProfile, pnlLeaderboard, contentPane;

    public HomeScreen(ArrayList<PlayerClass> leaderboardArray) {

        this.leaderboardArray = leaderboardArray;

        leaderboardReader = new PlayersFileReaderClass(this.leaderboardArray);
        leaderboardReader.readFromFile();
        
        questionsArray = new ArrayList<>();
        questionReader = new QuestionFileReaderClass(questionsArray);

        this.setTitle("QuizApp");
        this.setSize(800, 400);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setButton();
        this.setList();
        this.setLabel();
        this.setPanels();

        contentPane = new JPanel(new BorderLayout()) {
            @Override // paint the background
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImageIcon = new ImageIcon("assets/background.jpeg");
                Image backgroundImage = backgroundImageIcon.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        this.setContentPane(contentPane);
        this.setVisible(true);
        this.addToFrame();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void setButton() {

        this.btnPlay = new JButton("PLAY NOW");
        this.btnPlay.setIcon(new ImageIcon("assets/play.png")); // sets the image near the button
        this.btnPlay.setBackground(Color.white);
        this.btnPlay.setBorderPainted(false); // removes border
        this.btnPlay.addActionListener(this);
        this.btnPlay.setActionCommand("play");
        this.btnPlay.setOpaque(false); // removes transparency

        this.btnOptions = new JButton();
        this.btnOptions.setIcon(new ImageIcon("assets/options.png"));
        this.btnOptions.setBackground(Color.white);
        this.btnOptions.setBorderPainted(false);
        this.btnOptions.addActionListener(this);
        this.btnOptions.setActionCommand("options");
        this.btnOptions.setOpaque(false);

        this.btnExit = new JButton();
        this.btnExit.setIcon(new ImageIcon("assets/exit.png"));
        this.btnExit.setBackground(Color.white);
        this.btnExit.setBorderPainted(false);
        this.btnExit.addActionListener(this);
        this.btnExit.setActionCommand("exit");
        this.btnExit.setOpaque(false);

        this.btnProfile = new JButton("CREATE NEW PROFILE");
        this.btnProfile.setBackground(Color.white);
        this.btnProfile.addActionListener(this);
        this.btnProfile.setActionCommand("profile");
        this.btnProfile.setOpaque(false);

    }

    private void setList() {
        this.leaderboardList = new LeaderboardList(leaderboardArray);
    }

    private void setLabel() {

        this.lblLeaderboard = new JLabel(new ImageIcon("assets/leaderboard.png"));
        this.lblLeaderboard.setText("LEADERBOARD");

        this.lblAvatar = new JLabel(new ImageIcon("assets/avatar.png"));

        this.lblLogo = new JLabel(new ImageIcon("assets/logo.png"));

    }

    private void setPanels() {

        this.pnlNord = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.pnlNord.add(btnOptions);
        this.pnlNord.setOpaque(false);

        this.pnlPlay = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        this.pnlPlay.add(btnPlay);
        this.pnlPlay.setOpaque(false);

        this.pnlCenter = new JPanel(new GridLayout(2, 1));
        this.pnlCenter.add(lblLogo);
        this.pnlCenter.add(pnlPlay);
        this.pnlCenter.setOpaque(false);

        this.pnlSud = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.pnlSud.add(btnExit);
        this.pnlSud.setOpaque(false);

        this.pnlProfile = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.pnlProfile.add(btnProfile);
        this.pnlProfile.setOpaque(false);

        this.pnlEast = new JPanel();
        this.pnlEast.setLayout(new GridLayout(2, 1));
        this.pnlEast.add(lblAvatar);
        this.pnlEast.add(pnlProfile);
        this.pnlEast.setOpaque(false);

        this.pnlLeaderboard = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.pnlLeaderboard.add(leaderboardList);
        this.pnlLeaderboard.setOpaque(false);

        this.pnlWest = new JPanel();
        this.pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
        this.pnlWest.add(lblLeaderboard);
        this.pnlWest.add(pnlLeaderboard);
        this.pnlWest.setOpaque(false);
    }

    private void addToFrame() {

        this.add(pnlNord, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlSud, BorderLayout.SOUTH);
        this.add(pnlEast, BorderLayout.EAST);
        this.add(pnlWest, BorderLayout.WEST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "play":
                questionReader.readFromFile();
                this.dispose();
                
                QuizScreen quizScreen = new QuizScreen(questionsArray);
                break;

            case "exit":
                System.exit(0);
                break;

        }

    }
}
