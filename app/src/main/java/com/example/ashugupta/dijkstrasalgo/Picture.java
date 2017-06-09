package com.example.ashugupta.dijkstrasalgo;

/**
 * Created by ashugupta on 08/06/17.
 */

public class Picture {
    private int image_ref;
    private String direction;

    Picture(String direction, int image_ref){
        this.image_ref = image_ref;
        this.direction = direction;

    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getImage_ref() {
        return image_ref;
    }

    public void setImage_ref(int image_ref) {
        this.image_ref = image_ref;
    }
}
