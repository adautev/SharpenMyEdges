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
        Integer[] testArraySelectionSort = {3,7,4,9,5,2,6,1};
        SelectionSort.Sort(testArraySelectionSort);
        if (!Arrays.equals(testArraySelectionSort,new Integer[] {9,7,6,5,4,3,2,1})) {
            throw new Exception("SelectionSort not working. (:");
        }
        String[] testArrayShellSort = {"t","h","e"," ","r","o","a","d"," ","t","o"," ","h","e","l","l"," ","i","s"," ","p","a","v","e","d"," ","w","i","t","h"," ","g","o","o","d"," ","i","n","t","e","n","t","i","o","n","s"};
        String[] sortedTestArrayShellSort = {" "," "," "," "," "," "," "," ","a","a","d","d","d","e","e","e","e","g","h","h","h","i","i","i","i","l","l","n","n","n","o","o","o","o","o","p","r","s","s","t","t","t","t","t","v","w"};
        ShellSort.Sort(testArrayShellSort);
        if(!Arrays.equals(testArrayShellSort, sortedTestArrayShellSort)) {
            throw new Exception("Shell sort not working. (:");
        }
        System.out.println("Sorting tests completed successfully.");
    }

}
