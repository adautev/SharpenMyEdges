package SortingAlgorithms;

public class InsertSort {
    public static void SortFor(int[] elements) {
        for(int i = 0; i <= elements.length - 1; i++) {
            for (int j = i; j > 0 && elements[j] < elements[j-1]; j--) {
                int swapElement = elements[j];
                elements[j] = elements[j-1];
                elements[j-1] = swapElement;
            }
        }
    }
}
