public class PlayerLinkedList {
    private PlayerNode head;
    private int size;

    // Adds a new player to the beginning of the list
    public void addToFront(Player player) {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
        size++;
    }

    // Removes the first element from the list
    public PlayerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        PlayerNode removedNode = head;
        head = head.getNextPlayer();
        size--;
        removedNode.setNextPlayer(null);
        return removedNode;
    }

    // Returns the current number of elements in the list
    public int getSize() {
        return size;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Checks if the list contains a specific player
    public boolean contains(Player player) {
        PlayerNode current = head;
        while (current != null) {
            if (player.equals(current.getPlayer())) {
                return true;
            }
            current = current.getNextPlayer();
        }
        return false;
    }

    // Finds the index of the first occurrence of a specific player
    public int indexOf(Player player) {
        PlayerNode current = head;
        int index = 0;
        while (current != null) {
            if (player.equals(current.getPlayer())) {
                return index;
            }
            current = current.getNextPlayer();
            index++;
        }
        return -1;
    }

    public void printList() {
        System.out.println("HEAD:");
        PlayerNode current = head;
        while (current != null) {
            System.out.println("  " + current.getPlayer());
            current = current.getNextPlayer();
        }
        System.out.println("-> null"); // Indicate the end
        System.out.println("(Size: " + size + ")");
    }
}
