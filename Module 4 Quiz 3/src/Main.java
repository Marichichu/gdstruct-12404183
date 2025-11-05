import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Initialize the queue with a starting capacity
        ArrayQueue queue = new ArrayQueue(10);

        int gamesCreated = 0;
        int turn = 1;
        int playerIdCounter = 1; // To give unique IDs to new players

        // Loop until 10 games are created
        while (gamesCreated < 10) {
            System.out.println("--- Turn " + (turn++) + " (Games created: " + gamesCreated + "/10) ---");
            System.out.println("Press Enter to simulate new players joining...");
            scanner.nextLine(); // Waits for the user to press Enter


            //  Add  players to the queue (x = 1 to 7)
            int playersToQueue = random.nextInt(7) + 1;
            System.out.println(playersToQueue + " players joined the queue.");

            for (int i = 0; i < playersToQueue; i++) {
                // Create a new player with a unique ID and random level
                Player newPlayer = new Player(playerIdCounter, "Player" + playerIdCounter, random.nextInt(100) + 1);
                queue.add(newPlayer);
                System.out.println("  - " + newPlayer.getUserName() + " (Level " + newPlayer.getLevel() + ") entered matchmaking.");
                playerIdCounter++;
            }

            System.out.println("\nCurrent queue size: " + queue.size());
            queue.printQueue();

            // Check if a game can start
            if (queue.
                    size() >= 5) {
                gamesCreated++;
                System.out.println("\n--- GAME " + gamesCreated + " STARTING! ---");
                System.out.println("Removing 5 players from queue:");

                // remove the first 5 players from the queue
                for (int i = 0; i < 5; i++) {
                    Player removedPlayer = queue.remove();
                    System.out.println("  - " + removedPlayer.getUserName() + " has joined the game.");
                }
                System.out.println("--- GAME " + gamesCreated + " IN PROGRESS ---\n");
            } else {
                System.out.println("\nNot enough players to start a game. Waiting for more...\n");
            }
            System.out.println("---------------------------------");


        }

        //  Terminate the program
        System.out.println("\n10 games have been successfully created. Program terminating.");
        scanner.close();
    }
}