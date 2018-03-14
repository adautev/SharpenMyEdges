package PriorityQueues;

import SortingAlgorithms.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        Integer[] testValues = {3,7,4,9,5,2,6,1};
        BinaryHeapMaxPriorityQueue<Integer> maxPriorityQueue = new BinaryHeapMaxPriorityQueue<Integer>(testValues.length);
        for(Integer value : testValues) {
            maxPriorityQueue.Insert(value);
        }
        Comparable[] mpqResultArray = maxPriorityQueue.ToArray();
        if(!Arrays.equals(new Integer[] {9,7,6,3,5,2,4,1}, mpqResultArray)){
            throw new Exception("Max priority queue not ordered correctly.");
        }
        maxPriorityQueue.DeleteMaximum();
        mpqResultArray = maxPriorityQueue.ToArray();
        if(!Arrays.equals(new Integer[] {7,5,6,3,1,2,4, null}, mpqResultArray)){
            throw new Exception("Max priority queue not deleting correctly.");
        }
    }

}
