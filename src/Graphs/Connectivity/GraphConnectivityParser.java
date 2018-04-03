package Graphs.Connectivity;

import Graphs.UndirectedGraph;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphConnectivityParser {
    private final int[] connectedComponents;
    private boolean[] visitedVertices;
    private int currentIterationCount = 0;
    public GraphConnectivityParser(UndirectedGraph graph) {
        this.visitedVertices = new boolean[graph.CountVertices()];
        this.connectedComponents = new int[graph.CountVertices()];
        for(int i = 0; i < graph.CountVertices(); i++) {
            this.visitedVertices[i]=false;
            this.connectedComponents[i]=-1;
        }
        this.DepthFirstSearchFindConnectedComponents(graph);
    }
    private void DepthFirstSearchFindConnectedComponents(UndirectedGraph graph) {
        for(int i = 0; i < graph.CountVertices(); i++) {
            if(!this.visitedVertices[i]) {
                DepthFirstSearch(graph, i);
                this.currentIterationCount++;
            }
        }
    }
    private void DepthFirstSearch(UndirectedGraph graph, int source) {
        this.visitedVertices[source] = true;
        this.connectedComponents[source] = this.currentIterationCount;
        for(int adjacentVertice: graph.AdjacentVertices(source)) {
            if (!this.visitedVertices[adjacentVertice]) {
                DepthFirstSearch(graph, adjacentVertice);
            }
        }
    }
    //Too lazy? https://stackoverflow.com/questions/32444193/count-different-values-in-array-in-java
    public int Count() {
        int numOfDifferentVals = 0;

        ArrayList<Integer> diffNum = new ArrayList<>();

        for(int i=0; i<connectedComponents.length; i++){
            if(!diffNum.contains(connectedComponents[i]) && connectedComponents[i] != -1){
                diffNum.add(connectedComponents[i]);
            }
        }

        if(diffNum.size()==1){
            numOfDifferentVals = 0;
        }
        else{
            numOfDifferentVals = diffNum.size();
        }

        return numOfDifferentVals;
    }
    public int VertexId(int vertex) {
        return this.connectedComponents[vertex];
    }
    public boolean Connected(int sourceVertex, int destinationVertex) {
        throw new NotImplementedException();
    }

}
