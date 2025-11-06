import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random; // Import the Random class
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // Initialization
        Random random = new Random(); // Create a Random object for automation
        Scanner scanner = new Scanner(System.in);
        CardStack playerDeck = new CardStack();
        CardStack discardPile = new CardStack();

        List<Card> playerHand = new ArrayList<>();

        // Initialize Player Deck (30 Standard Cards)
        List<Card> cardsToShuffle = new ArrayList<>();

        // Create all 52 standard cards
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cardsToShuffle.add(new Card(suit, rank));
            }
        }

        // Shuffle the full 52-card deck
        Collections.shuffle(cardsToShuffle);

        // Take the first 30 shuffled cards to be our deck
        for (int i = 0; i < 30; i++) {
            playerDeck.push(cardsToShuffle.get(i));
        }

        System.out.println("Standard 30-card deck initialized and shuffled.");
        System.out.println("-------------------------------------------\n");

        // Start Game Loop
        int turn = 1;
        // The game ends when the player deck is empty
        while (!playerDeck.isEmpty()) {
            System.out.println("=== Turn " + (turn++) + " ===");

            // Choose a random command
            int command = random.nextInt(3) + 1; // Generates 1, 2, or 3
            int x; // To store the number of cards

            switch (command) {
                case 1: // Draw x cards
                    x = random.nextInt(5) + 1; // Random value from 1 to 5
                    System.out.println("Command: Draw " + x + " cards.");
                    for (int i = 0; i < x; i++) {
                        if (playerDeck.isEmpty()) {
                            System.out.println("...but the deck is empty!");
                            break; // Stop drawing
                        }
                        Card drawnCard = playerDeck.pop();
                        playerHand.add(drawnCard);
                        System.out.println("Drew a: " + drawnCard);
                    }
                    break;

                case 2: // Discard x cards
                    x = random.nextInt(5) + 1; // Random value from 1 to 5
                    System.out.println("Command: Discard " + x + " cards.");
                    for (int i = 0; i < x; i++) {
                        if (playerHand.isEmpty()) {
                            System.out.println("...but your hand is empty!");
                            break; // Stop discarding
                        }

                        Card discardedCard = playerHand.remove(playerHand.size() - 1);
                        discardPile.push(discardedCard);

                        System.out.println("Discarded a: " + discardedCard);
                    }
                    break;

                case 3: // Get x cards from the discarded pile
                    x = random.nextInt(5) + 1; // Random value from 1 to 5
                    System.out.println("Command: Get " + x + " cards from discard.");
                    for (int i = 0; i < x; i++) {
                        if (discardPile.isEmpty()) {
                            System.out.println("...but the discard pile is empty!");
                            break; // Stop getting
                        }
                        Card retrievedCard = discardPile.pop();
                        playerHand.add(retrievedCard);
                        System.out.println("Retrieved a: " + retrievedCard);
                    }
                    break;
            }

            // Display info after the round is complete
            System.out.println("\n--- Round " + (turn - 1) + " Summary ---");
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Cards in Deck: " + playerDeck.size());
            System.out.println("Cards in Discard: " + discardPile.size());
            System.out.println("------------------------\n");

            System.out.print("Press Enter to continue to the next turn...");
            scanner.nextLine(); // Pauses and waits for the user to press Enter
            System.out.println(); // Adds a clean line break
        }

        //End Game
        System.out.println("\nGAME OVER: The player deck is empty.");
        System.out.println("Final Hand: " + playerHand);

        scanner.close();
    }
}