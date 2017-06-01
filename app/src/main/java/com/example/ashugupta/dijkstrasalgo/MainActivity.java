package com.example.ashugupta.dijkstrasalgo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button createGraph,findPath;
    EditText source,destination;
    Graph graph;
    TextView Path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGraph = (Button) findViewById(R.id.btn_create_graph);
        findPath = (Button) findViewById(R.id.btn_find_path);
        source = (EditText) findViewById(R.id.source);
        Path = (TextView) findViewById(R.id.path);
        destination = (EditText) findViewById(R.id.destination);

        createGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graph =  new Graph();
                Toast.makeText(MainActivity.this, "Graph Created!", Toast.LENGTH_SHORT).show();
            }
        });
        findPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
                int sourceVertex = Integer.parseInt(source.getText().toString());
                int destVertex = Integer.parseInt(destination.getText().toString());
                dijkstra.execute(graph.getVertexes().get(sourceVertex));
                LinkedList<Vertex> path = dijkstra.getPath(graph.getVertexes().get(destVertex));
                Path.setText("");
                for (Vertex vertex : path) {
                    Path.append(vertex.getName() + "\n");
                }

            }
        });
        
        
    }



}
