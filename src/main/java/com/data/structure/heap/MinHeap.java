package com.data.structure.heap;

import com.data.structure.heap.exception.HeapFullException;
import com.data.structure.heap.exception.HeapEmptyException;

public class MinHeap<T extends Comparable> extends Heap<T> {

    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    public MinHeap(Class clazz) {
        super(clazz);
    }

    @Override
    public void siftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        //find min of left and right child elements
        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            //choose the min element index
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ?
                    leftIndex : rightIndex;
        } else if (rightIndex != -1) {
            smallerIndex = rightIndex;
        } else if (leftIndex != -1) {
            smallerIndex = leftIndex;
        }
        //if left and righ child do not exist stop sifting down..
        if (smallerIndex == -1) {
            return;
        }

        //compare the smaller child with current index to see if swap isneeded
        //and further swift down if needed
        if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(smallerIndex, index);
            siftDown(smallerIndex);
        }
    }

    @Override
    public void siftUp(int index) {
        int parentIndex = getParentIndex(index);
        if (parentIndex == -1) {
            return;
        }
        //current npode value is less than parent means element is at wrong position swap..
        if (parentIndex != -1 && getElementAtIndex(index).compareTo(parentIndex) < 0) {
            swap(parentIndex, index);
            siftUp(parentIndex);
        }
    }

    public void insert(T value) throws HeapFullException {
        //O(Log N)
        if (count >= array.length) {
            throw new HeapFullException();
        }
        array[count] = value;//append element to end of the array..
        siftUp(count);
        count++;
    }

    public T removeHighestPriority() throws HeapEmptyException {
        //O(Log N)
        T data = getHighestPriority();
        array[0] = array[count - 1];
        count--;
        siftDown(0);//restores the heap, re-heapify...
        return data;
    }

    private T getHighestPriority() throws HeapEmptyException {
        if(count ==0){
            throw new HeapEmptyException();
        }
        //O(1) constant time
        return array[0];
    }
}
