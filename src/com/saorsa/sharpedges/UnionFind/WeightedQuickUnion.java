package com.saorsa.sharpedges.UnionFind;

public class WeightedQuickUnion {
    private final int elementsCount;
    private final int[] elements;
    private final int[] treesSize;
    public WeightedQuickUnion(int ElementsCount) {
        this.elementsCount = ElementsCount;
        this.elements = new int[ElementsCount];
        this.treesSize = new int[ElementsCount];
        for (int i = 0; i < this.elementsCount; i++) {
            this.elements[i]=i;
            this.treesSize[i] = 1;
        }
    }
    public void Union(int sourceIndex, int destinationIndex) {
        int sourceParent = this.FindRoot(sourceIndex);
        int destinationParent = this.FindRoot(destinationIndex);
        if(this.treesSize[sourceIndex] < this.treesSize[destinationIndex]) {
            this.elements[sourceParent] = this.elements[destinationParent];
            this.treesSize[destinationParent] += this.treesSize[sourceParent];
        } else {
            this.elements[destinationParent] = this.elements[sourceParent];
            this.treesSize[sourceParent] += this.treesSize[destinationParent];
        }
    }

    public int FindRoot(int elementIndex) {
        while (elementIndex != this.elements[elementIndex]) {
            elementIndex = this.elements[elementIndex];
        }
        return elementIndex;
    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int element : this.elements) {
            stringBuilder.append(element + ",");
        }
        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 1);
    }
}
