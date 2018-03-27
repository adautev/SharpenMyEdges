package Graphs;

import StacksAndQueues.Bag;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UndirectedGraph {
    private final int vertices;
    private Bag<Integer>[] adjacendies;
    private int elementsCount;

    public UndirectedGraph(int vertices){
        this.vertices = vertices;
        this.adjacendies = (Bag<Integer>[])new Bag[vertices];
        for(Bag<Integer> adj: this.adjacendies) {
            adj = new Bag<>();
        }
    }
    Iterable<Integer> AdjacentVertices(int vertice) {
        throw new NotImplementedException();
    }
    int CountVertices() {
        throw new NotImplementedException();
    }
    int CountEdges() {
        throw new NotImplementedException();
    }
    void AddEdge(int vertice, int weight) {
        this.adjacendies[vertice].Add(weight);
        this.adjacendies[weight].Add(vertice);
        this.elementsCount++;
    }
}
