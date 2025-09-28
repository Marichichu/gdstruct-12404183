public class Main {

    public static void main (String[] args) {

        int[] numbers = {35, 69, 1, 10, -50, 320, 63, 58, 26, 13};

        System.out.println("===Initial Unsorted Array===");
        printArrayElements(numbers);


        int[] bubbleArray = copyArray(numbers);
        int[] selectionArray = copyArray(numbers);

        bubbleSortDescending(bubbleArray);
        selectionSortSmallestToEnd(selectionArray);

        System.out.println("\n===Result of Bubble Sort (Descending)===");
        printArrayElements(bubbleArray);

        System.out.println("\n===Result of Selection Sort (Descending)===");
        printArrayElements(selectionArray);
    }

    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    private static void bubbleSortDescending(int[] arr) {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            for (int i = 0; i < lastSortedIndex; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    private static void selectionSortSmallestToEnd(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int smallestIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (arr[i] < arr[smallestIndex]) {
                    smallestIndex = i;
                }
            }
            int temp = arr[lastUnsortedIndex];
            arr[lastUnsortedIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    private static void printArrayElements(int[] arr) {
        for (int j : arr) {
            System.out.println(j + " ");
        }
    }
}