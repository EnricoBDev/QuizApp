/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizapp.components;

/**
 * Custom thread to stop when using the progress bar
 * @author EnricoBDev
 */
public class ThreadTimedProgressBar extends Thread{
    TimedProgressBar bar;

    public ThreadTimedProgressBar(TimedProgressBar bar) {
        this.bar = bar;
    }
    
    @Override
    public void run(){
        try {
            for (int i = 0; i <= bar.getMaximum(); i++) {
                this.sleep(1000);
                bar.setValue(i);
                bar.setString(i + "/" + bar.getMaximum());
                bar.update(bar.getGraphics());
            }
        } catch (Exception e) {
        }
    }
}
