package com.example.ashugupta.dijkstrasalgo;

/**
 * Created by ashugupta on 01/06/17.
 */

public class Vertex {
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String argName) {
        name = argName;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
