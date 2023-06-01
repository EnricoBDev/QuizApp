package com.mycompany.quizapp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Custom thread to stop when using the progress bar
 *
 * @author EnricoBDev
 */
public class ThreadTimedProgressBar extends Thread {

    TimedProgressBar bar;
    JFrame frame;
    int timeToEnd;

    public ThreadTimedProgressBar(JFrame frame, TimedProgressBar bar) {
        this.frame = frame;
        this.bar = bar;
    }

    public int gettimeToEnd() {
        return timeToEnd;
    }

    public void settimeToEnd(int timeToEnd) {
        this.timeToEnd = timeToEnd;
    }

    @Override
    public void run() {
        try {
            for (this.timeToEnd = 0; this.timeToEnd <= bar.getMaximum(); this.timeToEnd++) {
                Thread.sleep(1000);
                bar.setValue(this.timeToEnd);
                bar.setString((bar.getMaximum() - this.timeToEnd) + " secondi rimasti");
                bar.update(bar.getGraphics());
            }
            frame.dispose();
            JOptionPane.showMessageDialog(frame, "Hai terminato il tempo a disposizione", "Tempo scaduto", JOptionPane.INFORMATION_MESSAGE);
            // TODO: insert what to show after game has ended
        } catch (Exception e) {
        }
    }
}
