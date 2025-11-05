
public class Main {

    public static void main(String[] args) {

        Player ploo = new Player(134, "Ploof", 135);
        Player wardell = new Player(530, "TSN Mardell", 640);
        Player deadlyJimmy = new Player(32, "DeadlyJimmy", 34);
        Player subroza = new Player(4931, "Subroza", 604);
        Player annieDro = new Player(6919, "C9 Annie", 593);

        SimpleHashtable hashtable = new SimpleHashtable();

        // Populate the hashtable
        hashtable.put(ploo.getUserName(), ploo);
        hashtable.put(wardell.getUserName(), wardell);
        hashtable.put(deadlyJimmy.getUserName(), deadlyJimmy);
        hashtable.put(subroza.getUserName(), subroza);
        hashtable.put(annieDro.getUserName(), annieDro);

        System.out.println("--- Hashtable after initial puts ---");
        hashtable.printHashtable();

        //Remove an item that caused a collision ("Ploof")
        System.out.println("\nRemoving 'Ploof'...");
        hashtable.remove("Ploof");

        System.out.println("\n--- Hashtable after removing 'Ploof' ---");
        hashtable.printHashtable();

        // Prove that we can still find "Subroza" after "Ploof" was removed
        System.out.println("\n--- Testing Get for 'Subroza' after removal ---");
        Player foundPlayer = hashtable.get("Subroza");
        if (foundPlayer != null) {
            System.out.println("Successfully found: " + foundPlayer);
        } else {
            System.out.println("Error: 'Subroza' not found after removal!");
        }

        // Remove a non-colliding item
        System.out.println("\nRemoving 'C9 Annie'...");
        hashtable.remove("C9 Annie");

        System.out.println("\n--- Hashtable after removing 'C9 Annie' ---");
        hashtable.printHashtable();
    }
}