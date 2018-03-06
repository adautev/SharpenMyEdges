package StacksAndQueues;

import java.util.Iterator;

public class StackLL<T> implements Iterable<T> {
    private Node<T> firstNode;
    public boolean isEmpty() {
        return firstNode == null;
    }
    public void Push(T value) {
        Node<T> oldNode = this.firstNode;
        this.firstNode = new Node<T>(value, oldNode);
    }
    public T Pop() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("No more mr. Nice Guy!");
        }
        T returnValue = this.firstNode.item;
        this.firstNode = this.firstNode.GetNextNode();
        return returnValue;
    }

    @Override
    public Iterator iterator() {
        return new StackLLIterator();
    }

    public class Node<T> {
        Node(T item, Node<T> nextNode) {
            this.item = item;
            this.nextNode = nextNode;
        }
        public Node<T> GetNextNode() {
            return this.nextNode;
        }
        public T GetValue() {
            return this.item;
        }
        private T item;
        private Node<T> nextNode;
    }
    private class StackLLIterator<T> implements Iterator {
        private Node<T> currentItem = (Node<T>) firstNode;

        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public T next() {
            return (T) Pop();
        }
    }
}
