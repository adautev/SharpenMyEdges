package SortingAlgorithms;

public class SelectionSort {
    public static <T extends Comparable<T>> T[] Sort(T[] elements) {
        for (int i=0; i < elements.length; i++) {
            T min = elements[i];
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
        return elements;
    }
}
