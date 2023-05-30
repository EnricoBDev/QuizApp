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

    private QuestionClass questionObj;
    private ArrayList<QuestionClass> questionArray;

    private String subject;
    private int difficulty;
    private String question;
    private String[] answers;

    public QuestionFileReaderClass(ArrayList<QuestionClass> questionsArray) {

        this.questionArray = questionsArray;

    }

    public void readFromFile() {

        FileReader file;
        BufferedReader fileReader;

        String read;
        StringTokenizer token;

        try {

            file = new FileReader("saves/questions.txt");
            fileReader = new BufferedReader(file);

            read = fileReader.readLine();

            while (read != null) {

                token = new StringTokenizer(read, ";");

                subject = token.nextToken();
                difficulty = Integer.valueOf(token.nextToken());
                question = token.nextToken();
                answers = new String[]{token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken()};

                questionObj = new QuestionClass(subject, difficulty, question, answers);
                questionArray.add(questionObj);
                read = fileReader.readLine();

            }

            file.close();

        } catch (Exception e) {
            System.out.println("Errore " + e.toString());
        }

    }

}
