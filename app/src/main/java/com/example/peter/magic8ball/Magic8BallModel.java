package com.example.peter.magic8ball;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Peter on 24-Aug-15.
 */
public class Magic8BallModel extends Object {

    static ArrayList<String> responseArray;

    /**
     Default Constructor. Sets the responseArray property with the
     initialResponseArray
     */
    public Magic8BallModel() {

        ArrayList<String> initialResponseArray = new ArrayList<String>();
        initialResponseArray.add("Yes");
        initialResponseArray.add("No");
        initialResponseArray.add("Maybe");
        initialResponseArray.add("I Don't Know");
        initialResponseArray.add("Can You Repeat The Question");
        initialResponseArray.add("You Wish");


        responseArray = initialResponseArray;
    }

    /**
     Default Constructor. Sets the responseArray property with the
     initialResponseArray
     and combines it with the extraResponseArray
     */
    public Magic8BallModel(ArrayList<String> extraResponseArray) {
        responseArray.addAll(extraResponseArray);
    }


    public String toString(){

        String newString = new String();

        newString += "Possible Responses: - ";
        for(String element : responseArray){
            newString += element + " - ";
        }

        return newString;
    }


    public String getResponse(){

        //Generate a Random Number
        Random rand = new Random();
        int randomNum = rand.nextInt((responseArray.size() - 1) + 1) + 0;

        //return a string variable response
        return new String(responseArray.get(randomNum));
    }


    public void addQuestion(String question) {
        responseArray.add(question);
    }


    public void askQuestion(String question){

        System.out.println("Question: " + question + "?");
        System.out.println("Response: " + getResponse());


    }


}
