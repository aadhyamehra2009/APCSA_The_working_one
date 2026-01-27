package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        // Selection sort: find the minimum element and place it at the beginning
        for (int i = 0; i < input.length - 1; i++) {
            // Find the index of the minimum element in the remaining unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the minimum element with the element at position i
            if (minIndex != i) {
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
            }
        }
    }
}
