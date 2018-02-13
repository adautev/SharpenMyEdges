package com.saorsa.sharpedges.UnionFind;

public class Main {

    public static void main(String[] args) {

        //Excercise, seed 756544
        QuickFind uqf = Q756544_Generate();
        if(!uqf.toString().equals("1,1,2,1,4,1,6,1,1,1")) {
            throw new IllegalStateException("Q: 756544 - not complete.");
        }
        QuickUnion uqu = Q393024_Generate();
        if(!uqu.toString().equals("3,3,5,3,9,3,3,1,5,2")) {
            throw new IllegalStateException("Q: Q393024 - not complete.");
        }
        System.out.println("All tests passed correctly. (:");
    }
    public static QuickFind Q756544_Generate() {
        QuickFind quickFind = new QuickFind(10);
        quickFind.Union(3,8);
        quickFind.Union(7,3);
        quickFind.Union(8,5);
        quickFind.Union(5,9);
        quickFind.Union(8,1);
        quickFind.Union(0,9);
        return quickFind;
    }
    public static QuickUnion Q393024_Generate() {
        QuickUnion quickUnion = new QuickUnion(10);
        //8-5   4-9   4-2   6-3   7-1 0-3 2-5   1-0   4-3
        quickUnion.Union(8, 5);
        quickUnion.Union(4, 9);
        quickUnion.Union(4, 2);
        quickUnion.Union(6, 3);
        quickUnion.Union(7, 1);
        quickUnion.Union(0, 3);
        quickUnion.Union(2, 5);
        quickUnion.Union(1, 0);
        quickUnion.Union(4, 3);
        return quickUnion;
    }
}
