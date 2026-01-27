package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        // Insertion sort: iterate through the array starting from the second element
        // For each element, shift larger elements to the right and insert the current element
        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            
            // Shift elements greater than key one position to the right
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j--;
            }
            // Insert the key at its correct position
            input[j + 1] = key;
        }
    }
}
