package com.mycompany.quizapp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author pietr
 */
public class PlayersFileWriterClass {

    private FileOutputStream fileStream;
    private ObjectOutputStream objectOutput;
    private ArrayList<PlayerClass> arrayPlayers = new ArrayList<>();

    public PlayersFileWriterClass(ArrayList<PlayerClass> arrayPlayers) {
        this.arrayPlayers = arrayPlayers;
    }

    public void writeToFile() {
        try {
            fileStream = new FileOutputStream("saves/players.dat");
            objectOutput = new ObjectOutputStream(fileStream);

            for (PlayerClass player : arrayPlayers) {
                objectOutput.writeObject(player);
                objectOutput.flush();
            }
            fileStream.close();
        } catch (IOException e) {
            System.out.println("Eccezione:" + e.getMessage());
        }
    }
}
