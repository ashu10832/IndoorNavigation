package com.example.ashugupta.dijkstrasalgo;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.example.ashugupta.dijkstrasalgo.R.id.destination;
import static com.example.ashugupta.dijkstrasalgo.R.id.source;


public class NavigationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    static TextView initalPos;
    LinkedList<Vertex> path;
    ArrayList<Edge> edges;
    Graph graph;
    String previousTurn;
    ArrayList<Route> route;
    //DiscreteScrollView discreteScrollView;
    private static final String TAG = "NavigationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Intent i = getIntent();
        edges = new ArrayList<>();
        graph = new Graph();
        findPath(i.getStringExtra("Source"),i.getStringExtra("Destination"));
        initalPos = (TextView) findViewById(R.id.initial_pos);
        route = new ArrayList<>();
        createRoute();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //discreteScrollView = (DiscreteScrollView) findViewById(R.id.discrete_scroll_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RouteAdapter adapter = new RouteAdapter(route,this);
        //discreteScrollView.setAdapter(adapter);
        recyclerView.setAdapter(adapter);
    }

    public static void setIntialText(String text){
        initalPos.setText(text);
    }

    void findPath(String source, String destination){
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        int sourceVertex = Integer.parseInt(source);
        int destVertex = Integer.parseInt(destination);
        dijkstra.execute(graph.getVertexes().get(sourceVertex));
        path = dijkstra.getPath(graph.getVertexes().get(destVertex));
    }

    private void getEdges(){
        edges.clear();
        ArrayList<Edge> allEdges = (ArrayList<Edge>) graph.getEdges();
        for (int i = 0;i<path.size() -1 ;i++){
            for (int j = 0;j<allEdges.size();j++){
                Edge edge = allEdges.get(j);
                if (edge.getSource().equals(path.get(i))&& edge.getDestination().equals(path.get(i+1))){
                    edges.add(edge);
                    Log.i(TAG, "Edges:Source " + edge.getSource().getName() + " Dest:" + edge.getDestination().getName() + " Direction:" + edge.getDirection());
                    break;
                }
            }
        }
    }



    public String getNewTurn(String previous, String next){
        String turn = null;
        if (previous.equals(next)){
            turn = "Straight";
        }
        else if (previous.equals("Right")){
            if (next.equals("Down")){
                turn = "Right";
            }
            else if (next.equals("Up")){
                turn = "Left";
            }
        }
        else if (previous.equals("Left")){
            if (next.equals("Down")){
                turn = "Left";
            }
            else if (next.equals("Up")){
                turn = "Right";
            }
        }
        else if (previous.equals("Up")){
            if (next.equals("Left")){
                turn = "Left";
            }
            else if (next.equals("Right")){
                turn = "Right";
            }
        }
        else if (previous.equals("Down")){
            if (next.equals("Left")){
                turn = "Right";
            }
            else if (next.equals("Right")){
                turn = "Left";
            }
        }
        return turn;
    }

    private String getDirection(Edge edge) {
        return edge.getDirection();
    }
    void  createRoute(){
        String nextTurn;
        getEdges();
        for (int i = 0; i < path.size(); i++) {
            Vertex vertex = path.get(i);
            if (i == 0) {
                previousTurn = getDirection(edges.get(i));
                setIntialText("You are at " + vertex.getName() + "\n" + "Go Straight Towards " + path.get(i+1).getName());
            } else if (i == path.size() - 1) {
                Route singleRoute = new Route();
                singleRoute.setTurn_image(R.drawable.marker);
                singleRoute.setInstruction("You have Reached at your Destination at " + vertex.getName());
                for (Picture picture: vertex.getPictures()) {
                    if (picture.getDirection().equals(previousTurn))
                        singleRoute.setImage(picture.getImage_ref());
                }
                route.add(singleRoute);
            } else {
                Route singleRoute = new Route();
                nextTurn = getDirection(edges.get(i));
                String newTurn = getNewTurn(previousTurn,nextTurn);
                for (Picture picture: vertex.getPictures()) {
                    if (picture.getDirection().equals(previousTurn))
                        singleRoute.setImage(picture.getImage_ref());
                }
                if (newTurn.equals("Right")){
                    singleRoute.setTurn_image(R.drawable.right_turn);
                }
                else if (newTurn.equals("Left")){
                    singleRoute.setTurn_image(R.drawable.left_turn);
                }
                else if (newTurn.equals("Straight")){
                    singleRoute.setTurn_image(R.drawable.straight_turn);
                }
                singleRoute.setInstruction("Go " + newTurn + " From " + vertex.getName());
                route.add(singleRoute);
                Log.i(TAG, "Previous:" + previousTurn + " NextTurn:" + nextTurn + " NewTurn:" + newTurn);
                previousTurn = getDirection(edges.get(i));
            }

        }
    }

}
