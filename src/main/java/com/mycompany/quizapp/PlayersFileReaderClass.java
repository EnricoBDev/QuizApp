package com.mycompany.quizapp;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author pietr
 */
public class PlayersFileReaderClass {

    private ObjectInputStream inputStream;
    private FileInputStream fileInput;
    private ArrayList<PlayerClass> arrayPlayers;

    public PlayersFileReaderClass(ArrayList<PlayerClass> arrayPlayers) {
        this.arrayPlayers = arrayPlayers;
    }

    public void readFromFile() {
        try {
            fileInput = new FileInputStream("saves/players.dat");
            inputStream = new ObjectInputStream(fileInput);

            while (true) {
                try {
                    PlayerClass player = (PlayerClass) inputStream.readObject();
                    arrayPlayers.add(player);
                } catch (EOFException e) {
                    // cycle interrupted
                    break;
                }
            }
            fileInput.close();

        } catch (Exception e) {

            System.out.println("Eccezione:" + e);
        }
    }
}
