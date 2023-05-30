package com.mycompany.quizapp;

/**
 * Custom thread to stop when using the progress bar
 * @author EnricoBDev
 */
public class ThreadTimedProgressBar extends Thread{
    TimedProgressBar bar;
    int remainingTime;

    public ThreadTimedProgressBar(TimedProgressBar bar) {
        this.bar = bar;
    }

    public int getRemainingTime() {
        return remainingTime;
    }
    
    @Override
    public void run(){
        try {
            for (this.remainingTime = 0; this.remainingTime <= bar.getMaximum(); this.remainingTime++) {
                Thread.sleep(1000);
                bar.setValue(this.remainingTime);
                bar.setString((bar.getMaximum() - this.remainingTime) + " secondi rimasti");
                bar.update(bar.getGraphics());
            }
        } catch (Exception e) {
        }
    }
}
