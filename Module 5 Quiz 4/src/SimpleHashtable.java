
public class SimpleHashtable {

    private StoredPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    //Adds a Player to the hashtable using linear probing for collisions.
    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    //Retrieves a Player from the hashtable.

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        return hashtable[hashedKey].value;
    }

    // Finds the correct index for a key using linear probing.Returns -1 if the key is not found.
    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }


    public Player remove(String key) {
        // Find the index of the key to remove
        int hashedKey = findKey(key);

        // Key not found
        if (hashedKey == -1) {
            return null;
        }

        // Key found, save the player to return
        Player removedPlayer = hashtable[hashedKey].value;

        // Set the slot to null (creates the "hole")
        hashtable[hashedKey] = null;

        // Re-hash all subsequent items in this collision cluster
        int oldIndex = hashedKey;
        int newIndex = (oldIndex + 1) % hashtable.length;

        // Loop until we find the next empty slot
        while (isOccupied(newIndex)) {
            StoredPlayer playerToRehash = hashtable[newIndex];

            hashtable[newIndex] = null;

            put(playerToRehash.key, playerToRehash.value);

            // Move to the next index in the cluster
            newIndex = (newIndex + 1) % hashtable.length;
        }

        // Return the player removed
        return removedPlayer;
    }


    public void printHashtable() {
        System.out.println("------------------------------------");
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                System.out.println("Element " + i + ": " + hashtable[i].value);
            } else {
                System.out.println("Element " + i + ": null");
            }
        }
        System.out.println("------------------------------------");
    }
}