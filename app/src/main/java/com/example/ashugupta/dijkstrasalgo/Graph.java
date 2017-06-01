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
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex D = new Vertex("D");
        Vertex F = new Vertex("F");
        Vertex K = new Vertex("K");
        Vertex J = new Vertex("J");
        Vertex M = new Vertex("M");
        Vertex O = new Vertex("O");
        Vertex P = new Vertex("P");
        Vertex R = new Vertex("R");
        Vertex Z = new Vertex("Z");

        // set the edges and weight
        A.adjacencies = new Edge[]{ new Edge(M, 8) };
        M.adjacencies = new Edge[]{ new Edge(A, 8) };
        M.adjacencies = new Edge[]{ new Edge(R,  8) };
        R.adjacencies = new Edge[]{ new Edge(M,  8) };
        R.adjacencies = new Edge[]{ new Edge(P, 15) };
        P.adjacencies = new Edge[]{ new Edge(Z, 18) };
        Z.adjacencies = new Edge[]{ new Edge(P, 18) };
        M.adjacencies = new Edge[]{ new Edge(B, 20) };
        B.adjacencies = new Edge[]{ new Edge(D, 11) };
        D.adjacencies = new Edge[]{ new Edge(B, 11) };
        B.adjacencies = new Edge[]{ new Edge(K, 20) };
        K.adjacencies = new Edge[]{ new Edge(O, 40) };
        F.adjacencies = new Edge[]{ new Edge(K, 23) };
        J.adjacencies = new Edge[]{ new Edge(K, 25) };
        O.adjacencies = new Edge[]{ new Edge(K, 40) };
        R.adjacencies = new Edge[]{ new Edge(F, 20) };




        vertexes.add(A);
        vertexes.add(B);
        vertexes.add(D);
        vertexes.add(F);
        vertexes.add(K);
        vertexes.add(J);
        vertexes.add(M);
        vertexes.add(O);
        vertexes.add(P);
        vertexes.add(R);
        vertexes.add(Z);
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }


}