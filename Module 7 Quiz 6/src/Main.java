public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();

        // Inserting a mix of values to test all BST properties
        System.out.println("Inserting data into the Binary Search Tree...");
        tree.insert(25);
        tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(18);
        tree.insert(26);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);
        System.out.println("Insertion complete.");

        // --- Traversal Operations ---

        // Traverse in descending order
        System.out.println("\n--- In-Order Traversal (Descending) ---");
        // Expected Output: 60, 55, 29, 26, 25, 18, 17, 10, -5
        tree.traverseInOrderDescending();

        // Retrieval Operations

        // Get the minimum value
        Node minNode = tree.getMin();

        System.out.println("\nMinimum Value Node: " + (minNode != null ? minNode.getData() : "N/A"));

        // Get the maximum value
        Node maxNode = tree.getMax();
        System.out.println("Maximum Value Node: " + (maxNode != null ? maxNode.getData() : "N/A"));
    }
}