public class Tree {
    private Node root;

    // Core Public Methods

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        }
        else {
            root.insert(value);
        }
    }

    public Node get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    // Traversal and Retrieval Methods

    // Iterative (O(log n) or O(h)) retrieval for min value
    public Node getMin() {
        if (root == null) {
            return null;
        }

        Node current = root;
        // The minimum is always the leftmost node
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    // Iterative (O(log n) or O(h)) retrieval for max value
    public Node getMax() {
        if (root == null) {
            return null;
        }

        Node current = root;
        // The maximum is always the rightmost node
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }

    // public entry point for In-Order Descending Traversal
    public void traverseInOrderDescending() {
        if (root != null) {
            // Calls the recursive helper method in the Node class
            root.traverseInOrderDescending();
        }
    }
}