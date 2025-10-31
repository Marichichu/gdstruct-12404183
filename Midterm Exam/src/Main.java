import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner; // Import the Scanner class

public class Main {

    public static void main(String[] args) {

        // Initialization
        Scanner scanner = new Scanner(System.in); // Create a Scanner for user input
        CardStack playerDeck = new CardStack();
        CardStack discardPile = new CardStack();

        List<Card> playerHand = new ArrayList<>();

        // Initialize Player Deck (52 Cards)
        List<Card> cardsToShuffle = new ArrayList<>();

        // Loop through all Suits
        for (Card.Suit suit : Card.Suit.values()) {
            // Loop through all Ranks
            for (Card.Rank rank : Card.Rank.values()) {
                cardsToShuffle.add(new Card(suit, rank));
            }
        }

        // Shuffle the list
        Collections.shuffle(cardsToShuffle);

        // Push the shuffled cards onto the deck (stack)
        for (Card card : cardsToShuffle) {
            playerDeck.push(card);
        }

        System.out.println("Standard 52-card deck initialized and shuffled.");
        System.out.println("-------------------------------------------\n");

        // Start Game Loop
        int turn = 1;
        // The game ends when the player deck is empty
        while (!playerDeck.isEmpty()) {
            System.out.println("=== Turn " + (turn++) + " ===");

            // Display current stats
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Cards in Deck: " + playerDeck.size());
            System.out.println("Cards in Discard: " + discardPile.size());
            System.out.println("\nChoose a command:");
            System.out.println("  1. Draw X cards");
            System.out.println("  2. Discard X cards");
            System.out.println("  3. Get X cards from discard");
            System.out.print("Enter command (1-3): ");

            int command = scanner.nextInt();
            int x; // To store the number of cards

            switch (command) {
                case 1: // Draw x cards
                    System.out.print("How many cards to draw? ");
                    x = scanner.nextInt();
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
                    System.out.print("How many cards to discard? ");
                    x = scanner.nextInt();
                    System.out.println("Command: Discard " + x + " cards.");
                    for (int i = 0; i < x; i++) {
                        if (playerHand.isEmpty()) {
                            System.out.println("...but your hand is empty!");
                            break; // Stop discarding
                        }

                        Card discardedCard = playerHand.remove(0);
                        discardPile.push(discardedCard);
                        System.out.println("Discarded a: " + discardedCard);
                    }
                    break;

                case 3: // Get x cards from the discarded pile
                    System.out.print("How many cards to get from discard? ");
                    x = scanner.nextInt();
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
                default:
                    System.out.println("Invalid command. Skipping turn.");
                    break;
            }

            System.out.println("------------------------\n");
        }

        //End Game
        System.out.println("\nGAME OVER: The player deck is empty.");
        System.out.println("Final Hand: " + playerHand);
        System.out.println("Final Discard Pile: " + discardPile.size() + " cards.");

        scanner.close(); // Close the scanner
    }
}