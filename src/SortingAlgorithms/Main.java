package SortingAlgorithms;

import com.saorsa.sharpedges.UnionFind.QuickFind;
import com.saorsa.sharpedges.UnionFind.QuickUnion;
import com.saorsa.sharpedges.UnionFind.WeightedQuickUnion;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        int[] testArray = {3,7,4,9,5,2,6,1};
        InsertSort.SortFor(testArray);
        if (!Arrays.equals(testArray,new int[] {1,2,3,4,5,6,7,9})) {
            throw new Exception("InsertSort.SortFor not working. (:");
        }
        System.out.println("Sorting tests completed successfully.");
    }

}
