package com.saorsa.sharpedges.UnionFind;

public class QuickUnion {
    private final int elementsCount;
    private final int[] elements;

    public QuickUnion(int ElementsCount) {
        this.elementsCount = ElementsCount;
        this.elements = new int[ElementsCount];
        for (int i = 0; i < this.elementsCount; i++) {
            this.elements[i]=i;
        }
    }
    public void Union(int sourceIndex, int destinationIndex) {
        int sourceParent = this.FindRoot(sourceIndex);
        int destinationParent = this.FindRoot(destinationIndex);
        this.elements[sourceParent] = destinationParent;
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
