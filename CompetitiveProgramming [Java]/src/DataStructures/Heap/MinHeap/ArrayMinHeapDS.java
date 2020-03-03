package DataStructures.Heap.MinHeap;

import java.util.Arrays;

public class ArrayMinHeapDS {

    /**
     * Best way to implement it is with an array
     */
    private int capacity = 10;
    private int[] items = new int[capacity];
    private int size = 0;

    public static void main(String[] args) {

        /**
         * Time Complexities:
         * Format -> Worst Case, Best Case
         * Space - O(n), O(n)
         * Search - O(n), O(n)
         * Insert - O(log n), O(1)
         * Delete - O(log n), O(log n)
         * Peek - O(1), O(1)
         */
    }

    //To get the index values
    private int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    //To check if the values are available
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    //To get the values
    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException("The heap is empty");
        return items[0];
    }

    /**
     * @return root (least) element and replace it with last element in heap. Then restore heap property (heapify)
     */
    public int poll() {
        if (size == 0) throw new IllegalStateException("The heap is empty");
        int item = items[0];
        items[0] = items[size - 1];
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                return;
            } else {
                swap(items[index], items[smallerChildIndex]);
            }

            index = smallerChildIndex;
        }
    }
}
