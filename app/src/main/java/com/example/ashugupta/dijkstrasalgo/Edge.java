package com.example.ashugupta.dijkstrasalgo;

/**
 * Created by ashugupta on 01/06/17.
 */

public class Edge {
    public final Vertex target;
    public final double weight;

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}

