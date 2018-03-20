package Trees;

import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree<K extends Comparable, V> implements Iterable {
    @Override
    public Iterator iterator() {
        LinkedList<K> queue = new LinkedList<>();
        inorderTravrersal(this.root, queue);
        return queue.iterator();
    }

    private void inorderTravrersal(Node refNode, LinkedList<K> queue) {
        if(refNode == null) return;
        inorderTravrersal(refNode.GetLeft(), queue);
        queue.add(refNode.GetKey());
        inorderTravrersal(refNode.GetRight(), queue);
    }

    private Node root;

    public int Rank(K key) {
        return Rank(this.root, key);
    }

    private int Rank(Node nodeRef, K key) {
        if(nodeRef == null) {
            return 0;
        }
        int compareResult = key.compareTo(nodeRef.GetKey());
        if(compareResult < 0) {
            return Rank(nodeRef.GetLeft(),key);
        } else if (compareResult > 0) {
            Node left = nodeRef.GetLeft();
            int leftCount = 0;
            if(left != null) {
                leftCount = left.GetSubNodesCount();
            }
            return 1 + leftCount + Rank(nodeRef.GetRight(),key);
        }
        else {
            Node left = nodeRef.GetLeft();
            if(left == null) { return 0; }
            return left.GetSubNodesCount();
        }

    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private int subNodesCount;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.SetSubNodesCount(1);
        }
        public K GetKey(){
            return this.key;
        }
        public void SetLeft(Node left) {
            this.left = left;
        }
        public void SetRight(Node right) {
            this.right = right;
        }
        public Node GetLeft() {
            return this.left;
        }
        public Node GetRight() {
            return this.right;
        }

        public V GetValue() {
            return this.value;
        }

        public void SetValue(V value) {
            this.value = value;
        }
        public void SetSubNodesCount(int size){
            this.subNodesCount = size;
        }


        public int GetSubNodesCount() {
            return  this.subNodesCount;
        }
    }
    public int Size() {
        return size(this.root);
    }

    @Override
    public String toString() {
        return toString(this.root);
    }
    public String toString(Node refNode) {
        StringBuilder nodeBuilder = new StringBuilder();
        if(refNode.GetLeft() != null) {
            nodeBuilder.append(this.toString(refNode.GetLeft()));
        }
        nodeBuilder.append(refNode.GetValue());
        if(refNode.GetRight() != null) {
            nodeBuilder.append(this.toString(refNode.GetRight()));
        }
        return nodeBuilder.toString();
    }
    private int size(Node node) {
        if(node == null) {
            return 0;
        }
        return node.GetSubNodesCount();
    }

    public void Put(K key, V value) {
        this.root = put(this.root, key, value);

    }

    private Node put(Node nodeRef, K key, V value) {
        if (nodeRef == null) return new Node(key, value);
        int compareResult = key.compareTo(nodeRef.GetKey());
        if (compareResult < 0) {
            nodeRef.SetLeft(put(nodeRef.GetLeft(), key, value));
        } else if (compareResult > 0) {
            nodeRef.SetRight(put(nodeRef.GetRight(), key, value));
        }
        else {
            nodeRef.SetValue(value);
        }
        Node left = nodeRef.GetLeft();
        Node right = nodeRef.GetRight();
        int leftCount = 0;
        int rightCount = 0;
        if(left != null) {
            leftCount = left.GetSubNodesCount();
        }
        if(right != null) {
            rightCount = right.GetSubNodesCount();
        }
        nodeRef.SetSubNodesCount(1 + leftCount + rightCount);
        return nodeRef;
    }

    public V Get(K key) {
        Node nodeRef = this.root;
        while (nodeRef != null) {
            int compareResult = key.compareTo(nodeRef.GetKey());
            if (compareResult < 0) {
                nodeRef = nodeRef.GetLeft();
            } else if (compareResult > 0) {
                nodeRef = nodeRef.GetRight();
            }
            else {
                return nodeRef.GetValue();
            }
        }
        return null;
    }
    public K Floor(K key) {
        Node refNode = floor(this.root, key);
        if(refNode == null) return null;
        return refNode.GetKey();
    }

    private Node floor(Node nodeRef, K key) {
        if (nodeRef == null) return null;
        int compareResult = key.compareTo(nodeRef.GetKey());
        if (compareResult == 0) {
            return nodeRef;
        } else if (compareResult < 0) {
            return floor(nodeRef.GetLeft(), key);
        }
        Node biggerKeysNode = floor(nodeRef.GetRight(), key);
        if (biggerKeysNode != null) {
            return biggerKeysNode;
        } else {
            return nodeRef;
        }
    }

    public void Delete(K key) {
        //Compress later
        this.Put(key, null);
    }
}

