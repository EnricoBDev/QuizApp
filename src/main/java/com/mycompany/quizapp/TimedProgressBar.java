package com.mycompany.quizapp.components;

import java.awt.Color;
import javax.swing.JProgressBar;

/**
 *
 * @author EnricoBDev
 */
public class TimedProgressBar extends JProgressBar {

    public TimedProgressBar() {
        this.setForeground(Color.decode("#6bf97e"));
        this.setBackground(Color.decode("#72aee5"));
        this.setString("");
        this.setMaximum(15);
        this.setStringPainted(true); // shows how much time is left to the user
    }

}
