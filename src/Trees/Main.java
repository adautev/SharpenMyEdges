package Trees;

import PriorityQueues.BinaryHeapMaxPriorityQueue;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        //The default algos implementation (x
        BinarySearchTree<String, String> testTree = new BinarySearchTree<>();
        testTree.Put("R", "R");
        testTree.Put("C", "C");
        testTree.Put("E", "E");
        testTree.Put("H", "H");
        testTree.Put("J", "J");
        testTree.Put("O", "O");
        testTree.Put("A", "A");
        String testRepresentation = testTree.toString();
        if(!testRepresentation.equals("ACEHJOR")){
            throw new Exception("Binary search tree not sorted correctly");
        }
        String floorTest = testTree.Floor("I");
        if(!floorTest.equals("H")){
            throw new Exception("Binary search floor not implemented correctly");
        }
        int rank = testTree.Rank("F");
        if(rank != 3){
            throw new Exception("Binary search rank not implemented correctly");
        }

        LeftLeaningRedBlueTree<String, String> testLLRBTree = new LeftLeaningRedBlueTree<>();
        testLLRBTree.Put("R", "R");
        testLLRBTree.Put("C", "C");
        testLLRBTree.Put("E", "E");
        testLLRBTree.Put("H", "H");
        testLLRBTree.Put("J", "J");
        testLLRBTree.Put("O", "O");
        testLLRBTree.Put("A", "A");
        String testLLRBTreeRepresentation = testLLRBTree.toString();
        if(!testLLRBTreeRepresentation.equals("ACEHJOR")){
            throw new Exception("Left Leaning Right Blue tree not sorted correctly");
        }
    }

}
