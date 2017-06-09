package com.example.ashugupta.dijkstrasalgo;

/**
 * Created by ashugupta on 01/06/17.
 */

public class Edge  {
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private final int weight;
    private String direction;

    public Edge(String id, Vertex source, Vertex destination, int weight,String direction) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.direction = direction;
    }

    public String getId() {
        return id;
    }
    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

