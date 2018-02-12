package com.saorsa.sharpedges.UnionFind;

public class UnionQuickFind {
    private final int elementsCount;
    private final int[] elements;

    public UnionQuickFind(int ElementsCount) {
        this.elementsCount = ElementsCount;
        this.elements = new int[ElementsCount];
        for (int i = 0; i < this.elementsCount; i++) {
            this.elements[i]=i;
        }
    }
    public void Union(int sourceIndex, int destinationIndex) {
        int sourceValue = this.elements[sourceIndex];
        int destinationValue = this.elements[destinationIndex];
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i] == sourceValue) {
                this.elements[i] = destinationValue;
            }
        }
    }

    public boolean Connected(int sourceIndex, int destinationIndex) {
        return this.elements[sourceIndex] == this.elements[destinationIndex];
    }
    int Find(int source) {
        return this.elements[source];
    }
    int Count() {
        return this.elementsCount;
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
