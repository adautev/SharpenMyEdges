package Graphs.Search;

import Graphs.UndirectedGraph;

import java.util.Stack;

public class DepthFirstPathFinder {
    private boolean visitedVertices[];
    private int edges[];
    private int source;
    public DepthFirstPathFinder(UndirectedGraph graph, int source) {
        this.edges = new int[graph.CountEdges()];
        this.visitedVertices = new boolean[graph.CountVertices()];
        this.source = source;
        DepthFirstSearch(graph, source);
    }

    private void DepthFirstSearch(UndirectedGraph graph, int source) {
        this.visitedVertices[source] = true;
        for(int adjacentVertice: graph.AdjacentVertices(source)) {
            if (!this.visitedVertices[adjacentVertice]) {
                DepthFirstSearch(graph, adjacentVertice);
                this.edges[adjacentVertice] = source;
            }
        }
    }
    private boolean isConnectedTo(int vertex) {
        return this.visitedVertices[vertex];
    }
    public Iterable<Integer> GetPath(int targetVertex) {
        if(!this.visitedVertices[targetVertex]) return null;
        Stack<Integer> traversedPath = new Stack<Integer>();
        for (int nextVertex = targetVertex; nextVertex != this.source; nextVertex=this.edges[nextVertex]) {
            traversedPath.push(nextVertex);
        }
        traversedPath.push(this.source);
        return traversedPath;
    }

}
