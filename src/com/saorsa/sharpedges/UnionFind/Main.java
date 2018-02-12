package com.saorsa.sharpedges.UnionFind;

public class Main {

    public static void main(String[] args) {

        //Excercise, seed 756544
        UnionQuickFind uqf = Q756544_Generate();
        if(!uqf.toString().equals("1,1,2,1,4,1,6,1,1,1")) {
            throw new IllegalStateException("Q: 756544 - not complete.");
        }
    }
    public static UnionQuickFind Q756544_Generate() {
        UnionQuickFind quickFind = new UnionQuickFind(10);
        quickFind.Union(3,8);
        quickFind.Union(7,3);
        quickFind.Union(8,5);
        quickFind.Union(5,9);
        quickFind.Union(8,1);
        quickFind.Union(0,9);
        return quickFind;
    }
}
