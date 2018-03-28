package Graphs;

import StacksAndQueues.Bag;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

public class UndirectedGraph {
    private Bag<Integer>[] adjacendies;
    private int sourceInex;

    public UndirectedGraph(int elementsCount){
        this.sourceInex = elementsCount;
        this.adjacendies = (Bag<Integer>[])new Bag[elementsCount];
        for(int i = 0; i < elementsCount; i++) {
            this.adjacendies[i]= new Bag<>();
        }
    }
    public Iterable<Integer> AdjacentVertices(int vertice) {
        return this.adjacendies[vertice];
    }
    public int CountVertices() {
        return this.adjacendies.length;
    }
    public int CountEdges() {
        return this.sourceInex;
    }
    void AddEdge(int vertice, int targetVertice) {
        this.adjacendies[vertice].Add(targetVertice);
        this.adjacendies[targetVertice].Add(vertice);
        this.sourceInex++;
    }


}
