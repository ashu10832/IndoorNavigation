package com.example.ashugupta.dijkstrasalgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button createGraph, findPath;
    EditText source, destination;

    Graph graph;
    TextView Path;
    ArrayList<Edge> edges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGraph = (Button) findViewById(R.id.btn_create_graph);
        findPath = (Button) findViewById(R.id.btn_find_path);
        source = (EditText) findViewById(R.id.source);
        Path = (TextView) findViewById(R.id.path);


        //Enter numder between 0 to 13 only currently

        destination = (EditText) findViewById(R.id.destination);
        edges = new ArrayList<>();
        createGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graph = new Graph();
                Toast.makeText(MainActivity.this, "Graph Created!", Toast.LENGTH_SHORT).show();
            }
        });
        findPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (source.getText().equals("") || destination.getText().equals("")) {
                    Toast.makeText(MainActivity.this, "Invalid Input!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
                    intent.putExtra("Source", source.getText().toString());
                    intent.putExtra("Destination", destination.getText().toString());
                    startActivity(intent);


                }
            }

        });


    }

}
