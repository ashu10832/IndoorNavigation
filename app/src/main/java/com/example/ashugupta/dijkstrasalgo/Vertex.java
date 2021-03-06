package com.example.ashugupta.dijkstrasalgo;

import java.util.ArrayList;

/**
 * Created by ashugupta on 01/06/17.
 */


public class Vertex {
    final private String id;
    final private String name;
    private ArrayList<Picture> pictures;


    public Vertex(String id, String name, ArrayList<Picture> pictures) {
        this.id = id;
        this.name = name;
        this.pictures  = new ArrayList<>(pictures);
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name;
    }



    public ArrayList<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<Picture> pictures) {
        this.pictures = pictures;
    }
}