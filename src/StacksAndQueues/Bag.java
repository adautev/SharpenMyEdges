package StacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private Node<Item> rootNode;   
    private int elementsCount;               

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        rootNode = null;
        elementsCount = 0;
    }

   
    
    public void Add(Item item) {
        Node<Item> previousElement = rootNode;
        rootNode = new Node<Item>();
        rootNode.item = item;
        rootNode.next = previousElement;
        elementsCount++;
    }


    public Iterator<Item> iterator()  {
        return new BagIterator<Item>(rootNode);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class BagIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public BagIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


}

