package com.example.ashugupta.dijkstrasalgo;

/**
 * Created by ashugupta on 08/06/17.
 */

public class Route {
    private int image;
    private int turn_image;
    private String instruction;

    Route(int image, int turn_image, String instruction){
        this.image = image;
        this.turn_image = turn_image;
        this.instruction = instruction;
    }

    Route(){

    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTurn_image() {
        return turn_image;
    }

    public void setTurn_image(int turn_image) {
        this.turn_image = turn_image;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
