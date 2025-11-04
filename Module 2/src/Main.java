public class Main {

    public static void main(String[] args) {

        //Create Player objects
        Player asuna = new Player(1, "Asuna", 100);
        Player lethalBacon = new Player(2, "LethalBacon", 205);
        Player hpDeskjet = new Player(3, "HPDeskjet", 34);
        Player heathcliff = new Player(4, "Heathcliff", 95);

        //Create new players
        Player mimi = new Player(5, "Mimi", 50);
        Player aerin = new Player(6, "Aerin", 75);
        Player lyra = new Player(7, "Lyra", 88);

        // Create an instance of the custom linked list
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        //Add original players
        System.out.println("Adding players...");
        playerLinkedList.addToFront(asuna);
        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.addToFront(hpDeskjet);
        playerLinkedList.printList();
        System.out.println("Current size: " + playerLinkedList.getSize());
        System.out.println("----------");

        //Add the new players
        System.out.println("Adding Mimi, Aerin, and Lyra...");
        playerLinkedList.addToFront(mimi);
        playerLinkedList.addToFront(aerin);
        playerLinkedList.addToFront(lyra);
        playerLinkedList.printList();
        System.out.println("Current size: " + playerLinkedList.getSize());
        System.out.println("----------");

        //Demonstrate contains
        System.out.println("Checking contains...");
        System.out.println("Contains Asuna? " + playerLinkedList.contains(new Player(1, "Asuna", 100)));
        System.out.println("Contains Lyra? " + playerLinkedList.contains(new Player(7, "Lyra", 88)));
        System.out.println("Contains Heathcliff? " + playerLinkedList.contains(heathcliff));
        System.out.println("----------");

        //Demonstrate indexOf
        System.out.println("Checking indexOf...");
        System.out.println("Index of Lyra: " + playerLinkedList.indexOf(new Player(7, "Lyra", 88)));
        System.out.println("Index of HPDeskjet: " + playerLinkedList.indexOf(new Player(3, "HPDeskjet", 34))); // 3
        System.out.println("Index of Asuna: " + playerLinkedList.indexOf(new Player(1, "Asuna", 100)));
        System.out.println("Index of Heathcliff: " + playerLinkedList.indexOf(heathcliff));
        System.out.println("----------");

        // Demonstrate removeFromFront
        System.out.println("Removing from front (Lyra)...");
        PlayerNode removed = playerLinkedList.removeFromFront();
        System.out.println("Removed: " + removed);
        playerLinkedList.printList();
        System.out.println("Current size: " + playerLinkedList.getSize());
        System.out.println("----------");
    }
}
