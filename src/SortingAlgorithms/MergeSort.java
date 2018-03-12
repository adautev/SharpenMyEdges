package SortingAlgorithms;

public class MergeSort {
    public static Comparable[] Sort(Comparable[] elements) {

        Sort(elements, new Comparable[elements.length],0, elements.length-1);
        return elements;
    }

    private static void Sort(Comparable[] elements, Comparable[] auxiliary, int low, int high) {
        if(high<=low) return;
        int mid = low + (high - low) / 2;
        Sort(elements, auxiliary, low, mid);
        Sort(elements, auxiliary, mid+1, high);
        Merge(elements, auxiliary, low, mid, high);
    }

    public static void Merge(Comparable[] elements, Comparable[] auxiliary, int low, int mid, int high) {
        for(int i = low; i <= high; i++) {
            auxiliary[i] = elements[i];
        }
        int left = low, right = mid+1;
        for(int i = left; i < high; i++) {
            if(left > mid) {
                elements[i]=auxiliary[right++];
            } else if(right > high) {
                elements[i] = auxiliary[left++];
            }
            if(auxiliary[right].compareTo(auxiliary[left]) <=0) {
                elements[i]=auxiliary[right++];
            } else {
                elements[i] = auxiliary[left++];
            }
        }
    }
}
