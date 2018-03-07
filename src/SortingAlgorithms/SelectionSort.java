package SortingAlgorithms;

public class SelectionSort {
    public static void Sort(Comparable[] elements) {
        for (int i=0; i < elements.length; i++) {
            Comparable min = elements[i];
            int swapIndex = 0;
            for (int j = i+1; j < elements.length; j++) {
                if(min.compareTo(elements[j]) < 0) {
                    min = elements[j];
                    swapIndex = j;
                }
            }
            if(swapIndex > 0) {
                elements[swapIndex] = elements[i];
                elements[i] = min;
            }
        }
    }
}
