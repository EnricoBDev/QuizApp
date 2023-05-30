package com.mycompany.quizapp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Model class for questions
 *
 * @author zotta
 */
public class QuestionClass implements Comparable<QuestionClass>{

    private String subject;
    private int difficulty;
    private String question;
    private String[] answers;
    private String correctAnswer;

    //constructor method
    public QuestionClass(String subject, int difficulty, String question, String[] answers) {
        this.subject = subject;
        this.difficulty = difficulty;
        this.question = question;
        this.answers = answers;
        
        this.correctAnswer = answers[0];
        
        List<String> answersList = Arrays.asList(this.answers);
        Collections.shuffle(answersList);
        answersList.toArray(this.answers);
    }

    //getter methods
    public String getSubject() {
        return subject;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    //setter method
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return " subject:" + subject + " difficulty: " + difficulty + " question: " + question + " answers: " + answers + " correctAnswer: " + correctAnswer;
    }

    // sorts based on difficulty
    @Override
    public int compareTo(QuestionClass t) {
        int result;
        result = this.difficulty - t.getDifficulty();
        if(result == 0){
            result = this.subject.compareTo(t.getSubject());
            if(result == 0){
                result = this.question.compareTo(t.getQuestion());
                if(result == 0){
                    for(int i = 0; i < 4; i++){
                        result = this.answers[i].compareTo(t.getAnswers()[i]);
                        if(result != 0){
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

}
