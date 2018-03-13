package SortingAlgorithms;

public class QuickSort {
    //One of the besties according to R&D
    public static void  Sort(Comparable[] elements) {
        ShuffleSort.Shuffle(elements);
        Sort(elements,0, elements.length -1);
    }

    private static void Sort(Comparable[] elements, int lowBoundary, int highBoundary) {
        if(highBoundary<=lowBoundary) {
            return;
        }
        int partitionIndex = Partition(elements, lowBoundary, highBoundary);
        Sort(elements, lowBoundary, partitionIndex -1);
        Sort(elements, partitionIndex + 1, highBoundary);
    }

    public static int Partition(Comparable[] elements, int lowBoundary, int highBoundary) {
        int i = lowBoundary;
        int j = highBoundary + 1;
        while (true) {
            while(elements[++i].compareTo(elements[lowBoundary]) < 0) {
                if (i == highBoundary) {
                    break;
                }
            }
            while(elements[lowBoundary].compareTo(elements[--j]) < 0) {
                if (i == highBoundary) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            Comparable swap = elements[i];
            elements[i] = elements[j];
            elements[j] = swap;

        }
        return j;
    }
}
