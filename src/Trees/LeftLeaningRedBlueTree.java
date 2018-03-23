package Trees;

public class LeftLeaningRedBlueTree<K extends  Comparable<K>, V> {
    private class Node {
        public static final boolean RED = true;
        public static final boolean BLUE = false;
        private K key;
        private V value;
        private boolean color;
        private Node left;
        private Node right;
        private int subNodesCount;
        public Node(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
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
    private Node root;
    public void Put(K key, V value) {
        this.root = put(this.root, key, value);

    }
    public boolean IsRed(Node node) {
        if(node == null) return false;
        return node.color;
    }
    private Node rotateLeft(Node nodeToRotate) {
        Node rightNode = nodeToRotate.GetRight();
        nodeToRotate.SetRight(rightNode.GetLeft());
        rightNode.SetLeft(nodeToRotate);
        rightNode.color = nodeToRotate.color;
        nodeToRotate.color = Node.RED;
        return rightNode;
    }
    private Node rotateRight(Node nodeToRotate) {
        Node leftNode = nodeToRotate.GetLeft();
        nodeToRotate.SetLeft(leftNode.GetRight());
        leftNode.SetRight(nodeToRotate);
        leftNode.color = nodeToRotate.color;
        nodeToRotate.color = Node.RED;
        return leftNode;
    }
    private void flipColors(Node node) {
        node.color = Node.RED;
        node.GetLeft().color = Node.BLUE;
        node.GetRight().color = Node.BLUE;
    }
    private Node put(Node nodeRef, K key, V value) {
        if (nodeRef == null) return new Node(key, value, Node.RED);
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
        if (IsRed(right) && !IsRed(left)){
            nodeRef = rotateLeft(nodeRef);
        }
        if (IsRed(left) && IsRed(left.left)) {
            nodeRef = rotateRight(nodeRef);
        }
        if (IsRed(left) && IsRed(right)) {
            flipColors(nodeRef);
        }
        return nodeRef;
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
}
