package SortingAlgorithms;

import java.util.Random;

public class ShuffleSort {
    public static void  Shuffle(Object[] elements) {
        for(int i = 0; i < elements.length; i++) {
            int randomPosition = new Random().nextInt(i+1);
            Object swap = elements[i];
            elements[i] = elements[randomPosition];
            elements[randomPosition] = swap;
        }
    }
}
