package com.example.ashugupta.dijkstrasalgo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashugupta on 01/06/17.
 */

public class Graph {
    private final ArrayList<Vertex> vertexes;
    private final ArrayList<Edge> edges;

    public Graph() {
        vertexes = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            vertexes.add(location);
        }
        addLane("Edge_0", 0, 1, 85);
        addLane("Edge_1", 0, 2, 217);
        addLane("Edge_2", 0, 4, 173);
        addLane("Edge_3", 2, 6, 186);
        addLane("Edge_4", 2, 7, 103);
        addLane("Edge_5", 3, 7, 183);
        addLane("Edge_6", 5, 8, 250);
        addLane("Edge_7", 8, 9, 84);
        addLane("Edge_12", 9, 8, 84);
        addLane("Edge_8", 7, 9, 167);
        addLane("Edge_9", 4, 9, 502);
        addLane("Edge_10", 9, 10, 40);
        addLane("Edge_11", 1, 10, 600);
    }
    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId,vertexes.get(sourceLocNo), vertexes.get(destLocNo), duration );
        edges.add(lane);
        lane = new Edge(laneId,vertexes.get(destLocNo),vertexes.get(sourceLocNo),duration);
        edges.add(lane);
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }



}