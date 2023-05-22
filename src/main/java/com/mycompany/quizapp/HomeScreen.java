package com.mycompany.quizapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Felice
 */
public class HomeScreen extends JFrame implements ActionListener {

    private ArrayList<Object> leaderboardArray = new ArrayList<>();

    private JList leaderboardList = new JList(); //update with custom JList

    private JButton btnPlay, btnExit, btnOptions, btnProfile;
    private JLabel lblLeaderboard, lblAvatar, lblLogo;

    private JPanel pnlNord, pnlCenter, pnlSud, pnlEast, pnlWest, pnlPlay, pnlProfile, pnlLeaderboard, contentPane;

    public HomeScreen(ArrayList<Object> leaderboardArray) {

        this.leaderboardArray = leaderboardArray;
        setTitle("QuizApp");
        setSize(800, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setButton();
        setLabel();
        setPanels();

        contentPane = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImageIcon = new ImageIcon("assets/background.jpeg");
                Image backgroundImage = backgroundImageIcon.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        setContentPane(contentPane);
        setVisible(true);
        addToFrame();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setButton() {

        btnPlay = new JButton("PLAY NOW");
        btnPlay.setIcon(new ImageIcon("assets/play.png"));
        btnPlay.setBackground(Color.white);
        btnPlay.setBorderPainted(false);
        btnPlay.addActionListener(this);
        btnPlay.setActionCommand("play");
        btnPlay.setOpaque(false);

        btnOptions = new JButton();
        btnOptions.setIcon(new ImageIcon("assets/options.png"));
        btnOptions.setBackground(Color.white);
        btnOptions.setBorderPainted(false);
        btnOptions.addActionListener(this);
        btnOptions.setActionCommand("options");
        btnOptions.setOpaque(false);

        btnExit = new JButton();
        btnExit.setIcon(new ImageIcon("assets/exit.png"));
        btnExit.setBackground(Color.white);
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(this);
        btnExit.setActionCommand("exit");
        btnExit.setOpaque(false);

        btnProfile = new JButton("CREATE NEW PROFILE");
        btnProfile.setBackground(Color.white);
        btnProfile.addActionListener(this);
        btnProfile.setOpaque(false);

    }

    private void setLabel() {

        lblLeaderboard = new JLabel(new ImageIcon("assets/leaderboard.png"));
        lblLeaderboard.setText("LEADERBOARD");

        lblAvatar = new JLabel(new ImageIcon("assets/avatar.png"));

        lblLogo = new JLabel(new ImageIcon("assets/logo.png"));

    }

    private void setPanels() {

        pnlNord = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlNord.add(btnOptions);
        pnlNord.setOpaque(false);
        pnlPlay = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        pnlPlay.add(btnPlay);
        pnlPlay.setOpaque(false);

        pnlCenter = new JPanel(new GridLayout(2, 1));
        pnlCenter.add(lblLogo);
        pnlCenter.add(pnlPlay);
        pnlCenter.setOpaque(false);

        pnlSud = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlSud.add(btnExit);
        pnlSud.setOpaque(false);

        pnlProfile = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlProfile.add(btnProfile);
        pnlProfile.setOpaque(false);

        pnlEast = new JPanel();
        pnlEast.setLayout(new GridLayout(2, 1));
        pnlEast.add(lblAvatar);
        pnlEast.add(pnlProfile);
        pnlEast.setOpaque(false);

        pnlLeaderboard = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlLeaderboard.add(leaderboardList);
        pnlLeaderboard.setOpaque(false);

        pnlWest = new JPanel();
        pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
        pnlWest.add(lblLeaderboard);
        pnlWest.add(pnlLeaderboard);
        pnlWest.setOpaque(false);
    }

    private void addToFrame() {

        add(pnlNord, BorderLayout.NORTH);
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlSud, BorderLayout.SOUTH);
        add(pnlEast, BorderLayout.EAST);
        add(pnlWest, BorderLayout.WEST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "exit":

                System.exit(0);

                break;

        }

    }
}
