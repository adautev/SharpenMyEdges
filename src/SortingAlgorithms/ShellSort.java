package SortingAlgorithms;

public class ShellSort {
    //One of the besties according to R&D
    private static final int[] sedgeWickSequence = new int[] {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609, 587521, 1045505, 2354689, 4188161, 9427969, 16764929, 37730305, 67084289, 150958081, 268386305, 603906049, 1073643521};
    public static void  Sort(Comparable[] elements) {
        //Not too much of an overhead I guess
        int[] sortIterations = new int[sedgeWickSequence.length];
        //Fallback to insertion sort
        int sortIterationNumber = 1;
        for(int x = 0; x < sedgeWickSequence.length && sedgeWickSequence[x] < elements.length; x++) {
            sortIterations[x] = sedgeWickSequence[x];
            sortIterationNumber = x;
        }
        for (int x=sortIterationNumber; x >=0; x--) {
            for(int i = sortIterations[x]; i < elements.length; i++) {
                Comparable swap = elements[i];
                int gap = sortIterations[x];
                int j = 0;
                for (j = i; j >= gap && elements[j - gap].compareTo(swap) > 0; j -= gap)
                {
                    elements[j] = elements[j - gap];
                }
                elements[j] = swap;
            }
        }
    }
}
