package Graphs;

import Graphs.Search.DepthFirstPathFinder;

public class Main {

    public static void main(String[] args) throws Exception {


        UndirectedGraph udGraph = new UndirectedGraph(13);
        udGraph.AddEdge(0,5);
        udGraph.AddEdge(4,3);
        udGraph.AddEdge(0,1);
        udGraph.AddEdge(9,12);
        udGraph.AddEdge(6,4);
        udGraph.AddEdge(5,4);
        udGraph.AddEdge(0,2);
        udGraph.AddEdge(11,12);
        udGraph.AddEdge(9,10);
        udGraph.AddEdge(0,6);
        udGraph.AddEdge(7,8);
        udGraph.AddEdge(9,11);
        udGraph.AddEdge(5,3);
        StringBuilder traverseResult = new StringBuilder();
        DepthFirstPathFinder dfpf = new DepthFirstPathFinder(udGraph,1);
        for(int edge: dfpf.GetPath(5)) {
            traverseResult.append(edge);
        }
        if(!traverseResult.toString().equals("54601")) {
            throw new Exception("Depth first path finder not implemented correctly");
        }
        System.out.println("Stacks and queues tests completed successfully.");
    }

}
