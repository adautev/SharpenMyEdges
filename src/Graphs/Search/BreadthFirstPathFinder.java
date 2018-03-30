package Graphs.Search;

import Graphs.UndirectedGraph;
import sun.misc.Queue;

public class BreadthFirstPathFinder {
    private boolean[] visitedVertices;
    private int[] edgeToVertice;
    private int[] distanceToVertice;
    private int sourceVertice;

    public BreadthFirstPathFinder() {

    }
    public void Search(UndirectedGraph graph, int sourceVertice) throws InterruptedException {
        this.sourceVertice = sourceVertice;
        this.visitedVertices = new boolean[graph.CountVertices()];
        this.edgeToVertice = new int[graph.CountVertices()];
        this.distanceToVertice = new int[graph.CountVertices()];
        Queue<Integer> traversePath = new Queue<>();
        traversePath.enqueue(sourceVertice);
        this.visitedVertices[sourceVertice] = true;
        while (!traversePath.isEmpty()) {
            int vertice = traversePath.dequeue();
            for(int targetVertice: graph.AdjacentVertices(vertice)) {
                if(!visitedVertices[targetVertice]) {
                    traversePath.enqueue(targetVertice);
                    visitedVertices[targetVertice] = true;
                    this.edgeToVertice[targetVertice] = vertice;
                    this.distanceToVertice[targetVertice] = this.distanceToVertice[vertice] + 1;
                }
            }

        }
    }
}
