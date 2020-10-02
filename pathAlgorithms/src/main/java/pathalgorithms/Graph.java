/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathalgorithms;

/**
 *
 * @author mikko
 */
public class Graph {

    private final String[] map;
    private final ArList[] arrayGraph;
    private int startVertex;
    private int endVertex;

    public Graph(String[] map, int vertices, int start, int end) {
        this.map = map;
        arrayGraph = new ArList[vertices];
        startVertex = start;
        endVertex = end;
    }

    public Graph(ArList[] adjacencyLists) {
        map = null;
        arrayGraph = adjacencyLists;
        startVertex = 0;
        endVertex = adjacencyLists.length - 1;
    }

    public void addAdjacent(int from, int to) {
        if (arrayGraph[from] == null) {
            arrayGraph[from] = new ArList(to);
        } else {
            arrayGraph[from].add(to);
        }

        if (arrayGraph[to] == null) {
            arrayGraph[to] = new ArList(from);
        } else {
            arrayGraph[to].add(from);
        }
    }

    public void addEmptyAdjacency(int from) {
        arrayGraph[from] = new ArList();
    }

    public ArList[] getArrayGraph() {
        return arrayGraph;
    }

    public int getStartVertex() {
        return startVertex;
    }

    public int getEndVertex() {
        return endVertex;
    }

    public void setStartVertex(int startVertex) {
        this.startVertex = startVertex;
    }

    public void setEndVertex(int endVertex) {
        this.endVertex = endVertex;
    }

    public int getNVertices() {
        return this.arrayGraph.length;
    }
 
    public void freezeAll() {
        for (ArList arList : arrayGraph) {
            arList.freeze();
        }
    }
}
