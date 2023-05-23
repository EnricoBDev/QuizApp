package com.mycompany.quizapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author studente
 */
public class QuestionFileReaderClass {

    private QuestionClass question;
    private ArrayList<QuestionClass> questionArray = new ArrayList<>();

    public QuestionFileReaderClass(ArrayList<QuestionClass> questionArray) {

        this.questionArray = questionArray;

    }

    public void readFromFile() {

        FileReader file;
        BufferedReader fileReader;

        String read;
        StringTokenizer token;

        try {

            file = new FileReader("files/questions.txt");
            fileReader = new BufferedReader(file);

            read = fileReader.readLine();

            while (read != null) {

                token = new StringTokenizer(read, ";");

                question = new QuestionClass(token.nextToken(), Integer.valueOf(token.nextToken()), token.nextToken(), new String[]{token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken()});
                questionArray.add(question);
                read = fileReader.readLine();

            }

            file.close();

        } catch (Exception eccezione) {

            System.out.println("errore");
        }

    }

}
