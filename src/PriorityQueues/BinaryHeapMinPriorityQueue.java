package PriorityQueues;

import java.util.Arrays;

public class BinaryHeapMinPriorityQueue<T extends Comparable<T>>{
    //Yes, yes, resizing heaps are an option! (: Yes, yes, I know you're hungry.. Aah, and here comes dinner!
    private T[] heap;
    private int capacity;
    private int lastElementIndex = 0;
    public BinaryHeapMinPriorityQueue(int size) {
        //Size + 1, as we don't use index 0.
        heap = (T[]) new Comparable[size+1];
        capacity = size+1;
    }
    public boolean isEmpty() {
        return this.capacity == 0;
    }
    private boolean Bigger(int elementIndexToCompare, int elementIndexToCompareAgainst) {
        return this.heap[elementIndexToCompare].compareTo(this.heap[elementIndexToCompareAgainst]) > 0;
    }
    private void Exchange(int sourceIndex, int destinationIndex) {
        T swap = this.heap[sourceIndex];
        this.heap[sourceIndex] = this.heap[destinationIndex];
        this.heap[destinationIndex] = swap;
    }
    private void Swim(int sourceIndex) {
       while (sourceIndex > 1 && this.Bigger(sourceIndex/2, sourceIndex)) {
           this.Exchange(sourceIndex, sourceIndex/2);
           sourceIndex/=2;
       }
    }
    private void Sink(int sourceIndex) {
        while (2*sourceIndex < this.lastElementIndex) {
            int compareChild = 2*sourceIndex;
            int rightCompareChild = compareChild+1;
            if(compareChild < this.lastElementIndex && this.Bigger(compareChild, rightCompareChild)) {
                compareChild++;
            }
            if(!this.Bigger(sourceIndex, compareChild))  break;
            this.Exchange(sourceIndex, compareChild);
            sourceIndex = compareChild;
        }
    }
    public void Insert(T key) {
        this.heap[++this.lastElementIndex] = key;
        this.Swim(this.lastElementIndex);
    }
    public T DeleteMinimum() {
        T maximumValueKey = this.heap[1];
        this.Exchange(1, this.lastElementIndex);
        this.Sink(1);
        this.heap[this.lastElementIndex] = null;
        return maximumValueKey;
    }
    public T[] ToArray() {
        return (T[]) Arrays.copyOfRange(this.heap, 1, this.capacity);
    }
}
