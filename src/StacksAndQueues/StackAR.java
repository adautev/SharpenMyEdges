package StacksAndQueues;

import java.lang.reflect.Array;
import java.util.Iterator;

public class StackAR<T> implements Iterable<T>{
    private T[] elementsContainer = (T[]) new Object[1];
    private int elementsCounter;
    public StackAR() {
    }

    public boolean isEmpty() {
        return this.elementsCounter == 0;
    }
    public void Push(T value) {
        if(this.elementsContainer.length == (this.elementsCounter+1)) {
            T[] newContainer = copyToNewArray(this.elementsContainer.length * 2);
            this.elementsContainer = newContainer;
        }
        this.elementsContainer[this.elementsCounter] = value;
        this.elementsCounter++;
    }

    private T[] copyToNewArray(int newArrayLength) {
        T[] newContainer = (T[]) new Object[newArrayLength];
        for (int i = 0; i < this.elementsContainer.length && newContainer.length > i; i++) {
            newContainer[i] = this.elementsContainer[i];
        }
        return newContainer;
    }

    public T Pop() {

        if(isEmpty()) {
            throw new IndexOutOfBoundsException("No more mr. Nice Guy!");
        }
        this.elementsCounter--;
        T returnValue = this.elementsContainer[this.elementsCounter];
        this.elementsContainer[this.elementsCounter] = null;
        if(this.elementsCounter <= (this.elementsContainer.length / 4)) {
            T[] newContainer = copyToNewArray(this.elementsContainer.length / 2);
            this.elementsContainer = newContainer;
        }
        return returnValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackARIterator();
    }

    private class StackARIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public T next() {
            if(isEmpty())
                throw new IndexOutOfBoundsException("The stack is empty. Next() is not supported in this context");
            return Pop();
        }
    }
}
