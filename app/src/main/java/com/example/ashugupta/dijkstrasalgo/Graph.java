package com.example.ashugupta.dijkstrasalgo;

import android.content.res.Resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ashugupta on 01/06/17.
 */

public class Graph  {
    private final ArrayList<Vertex> vertexes;
    private final ArrayList<Edge> edges;

    public Graph() {
        Resources resources = Resources.getSystem();
        vertexes = new ArrayList<>();
        edges = new ArrayList<>();
       /* for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            vertexes.add(location);
        }*/
       ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("Down",R.drawable.down_1));
        pictures.add(new Picture("Left",R.drawable.left_1));
       vertexes.add(new Vertex("Node_0","Node_0",pictures));
        pictures.clear();
        pictures.add(new Picture("Down",R.drawable.down_2));
        pictures.add(new Picture("Left",R.drawable.left_2));
        pictures.add(new Picture("Right",R.drawable.right_2));
        vertexes.add(new Vertex("Node_1","Node_1",pictures));
        pictures.clear();
        pictures.add(new Picture("Down",R.drawable.down_3));
        pictures.add(new Picture("Left",R.drawable.left_3));
        pictures.add(new Picture("Right",R.drawable.right_3));
        vertexes.add(new Vertex("Node_2","Node_2",pictures));
        pictures.clear();
        pictures.add(new Picture("Down",R.drawable.down_4));
        pictures.add(new Picture("Right",R.drawable.right_4));
        vertexes.add(new Vertex("Node_3","Node_3",pictures));
        pictures.clear();
        pictures.add(new Picture("Down",R.drawable.down_5));
        pictures.add(new Picture("Up",R.drawable.up_5));
        pictures.add(new Picture("Right",R.drawable.right_5));
        vertexes.add(new Vertex("Node_4","Node_4",pictures));
        pictures.clear();
        pictures.add(new Picture("Down",R.drawable.down_6));
        pictures.add(new Picture("Up",R.drawable.up_6));
        pictures.add(new Picture("Right",R.drawable.right_6));
        vertexes.add(new Vertex("Node_5","Node_5",pictures));
        pictures.clear();
        pictures.add(new Picture("Up",R.drawable.up_7));
        pictures.add(new Picture("Right",R.drawable.right_7));
        vertexes.add(new Vertex("Node_6","Node_6",pictures));
        pictures.clear();
        pictures.add(new Picture("Up",R.drawable.up_8));
        pictures.add(new Picture("Left",R.drawable.left_8));
        vertexes.add(new Vertex("Node_7","Node_7",pictures));
        pictures.clear();
        pictures.add(new Picture("Down",R.drawable.down_9));
        pictures.add(new Picture("Left",R.drawable.left_9));
        pictures.add(new Picture("Right",R.drawable.right_9));
        vertexes.add(new Vertex("Node_8","Node_8",pictures));
        pictures.clear();
        pictures.add(new Picture("Left",R.drawable.left_10));
        pictures.add(new Picture("Up",R.drawable.up_10));
        vertexes.add(new Vertex("Node_9","Node_9",pictures));
        pictures.clear();
        pictures.add(new Picture("Down",R.drawable.down_11));
        pictures.add(new Picture("Up",R.drawable.up_11));
        pictures.add(new Picture("Left",R.drawable.left_11));
        vertexes.add(new Vertex("Node_10","Node_10",pictures));
        pictures.clear();
        pictures.add(new Picture("Left",R.drawable.left_12));
        pictures.add(new Picture("Up",R.drawable.up_12));
        pictures.add(new Picture("Right",R.drawable.right_12));
        vertexes.add(new Vertex("Node_11","Node_11",pictures));
        pictures.clear();
        pictures.add(new Picture("Down",R.drawable.down_13));
        pictures.add(new Picture("Up",R.drawable.up_13));
        pictures.add(new Picture("Right",R.drawable.right_13));
        vertexes.add(new Vertex("Node_12","Node_12",pictures));
        pictures.clear();
        pictures.add(new Picture("Up",R.drawable.up_14));
        pictures.add(new Picture("Left",R.drawable.left_14));
        vertexes.add(new Vertex("Node_13","Node_13",pictures));
        pictures.clear();

        addLane("Edge_0", 0, 1, 20,"Right");
        addLane("Edge_1", 1, 2, 20,"Right");
        addLane("Edge_2", 2, 3, 20,"Right");
        addLane("Edge_3", 3, 4, 24,"Up");
        addLane("Edge_4", 4, 5, 16,"Up");
        addLane("Edge_5", 5, 6, 18,"Up");
        addLane("Edge_6", 6, 7, 20,"Left");
        addLane("Edge_7", 7, 8, 18,"Down");
        addLane("Edge_8", 8, 9, 40,"Left");
        addLane("Edge_9", 9, 10, 20,"Down");
        addLane("Edge_10", 10, 0, 20,"Down");
        addLane("Edge_11", 10, 11, 20,"Right");
        addLane("Edge_12",11 ,12,20, "Right");
        addLane("Edge_13", 12, 13, 4, "Up");
        addLane("Edge_14", 13, 4 , 20, "Right");
        addLane("Edge_15", 12, 2 , 20, "Down");
        addLane("Edge_16", 11, 1 , 20, "Down");
        addLane("Edge_17", 8, 5 , 20, "Right");
}
    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration,String direction) {
        Edge lane = new Edge(laneId,vertexes.get(sourceLocNo), vertexes.get(destLocNo), duration,direction );
        edges.add(lane);
        if (direction.equals("Right"))
            direction = "Left";
        else if (direction.equals("Left"))
            direction = "Right";
        else if (direction.equals("Up"))
            direction = "Down";
        else if (direction.equals("Down"))
            direction = "Up";
        lane = new Edge(laneId,vertexes.get(destLocNo),vertexes.get(sourceLocNo),duration,direction);
        edges.add(lane);
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }



}