package src.main.java;

import java.util.Random;

/**
 * Implementations of various sorting algorithm.
 * Sort array in increasing order
 */
public class Sorter {

    /**
     ******************************
     *        Selection Sort
     ******************************
     */
    public static void selectionSort(Comparable[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            // find the smallest item in array from i+1 to the end
            // exchange it with the item i
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    /**
     ******************************
     *        Insertion Sort
     ******************************
     */
    public static void insertionSort(Comparable[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            // insert array[i] among the items before a[i], such as
            // a[i-1], a[i-2] ....
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }

    /**
     ******************************
     *        Merge Sort
     ******************************
     */
    public static void mergeSort(Comparable[] array) {
        int length = array.length;
        Comparable[] aux = new Comparable[length];
        recursiveMergeSort(array, 0, length - 1, aux);
    }

    // private helper function for merge sort
    private static void recursiveMergeSort(Comparable[] array, int start, int end, Comparable[] aux) {
        // base case for recursive
        if (end <= start) {
            return;
        }
        int mid = (start + end) / 2;
        recursiveMergeSort(array, start, mid, aux);
        recursiveMergeSort(array, mid + 1, end, aux);
        merge(array, start, mid, end, aux);
    }

    // private helper function for merge sort
    // merge array[start.. mid] with array[mid_1...end]
    private static void merge(Comparable[] array, int start, int mid, int end, Comparable[] aux) {
        int i = start, j = mid + 1;
        // Copy content in array to aux
        for (int k = start; k <= end; k++) {
            aux[k] = array[k];
        }
        // Merge back to array[start... end]
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > end) {
                array[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    /**
     ******************************
     *        Quick Sort
     ******************************
     */
    public static void quickSort(Comparable[] array) {
        int length = array.length;
        shuffle(array);
        recursiveQuickSort(array, 0, length - 1);
    }

    // private helper function for quick sort
    private static void recursiveQuickSort(Comparable[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivotPoint = partition(array, start, end);
        recursiveQuickSort(array, start, pivotPoint - 1);
        recursiveQuickSort(array, pivotPoint + 1, end);
    }

    // private helper function of partition of quick sort
    private static int partition(Comparable[] array, int start, int end) {
        // partition array into array[start...pivot-1], array[pivot], array[pivot+1...end]
        int left = start, right = end + 1;
        // chose pivot point, arbitrarily chose the first item
        // can be optimized to chose a media of three value in the array or shuffle the array
        // make sure the input array is not mostly ordered, which will have runtime O(n^2)
        Comparable pivot = array[start];
        while (true) {
            while (less(array[++left], pivot)) if (left == end) break;
            while (less(pivot, array[--right])) if (right == start) break;
            if (left >= right) break;
            swap(array, left, right);
        }
        // pub pivot into its position
        swap(array, start, right);
        return right;
    }

    private static void shuffle(Comparable[] array) {
        int length = array.length;
        Random random = new Random();
        for (int i = 0; i< length; i++) {
            int indexToSwap = i + random.nextInt(length-i);
            swap(array, i, indexToSwap);
        }
    }

    /**
     ******************************
     *        Heap Sort
     ******************************
     */
    public static void heapSort(Comparable[] array) {
        int count = array.length;
        // heapify the array
        heapifyArray(array, count);
        // exchange the first with the last entry in the shrinking heap array
        int end = count - 1;
        while (end > 0) {
            swap(array, 0, end);
            end--;
            percolateDown(array, 0, end);
        }
    }

    // private method to heapify the arran
    private static void heapifyArray(Comparable[] array, int count) {
        // last parent item of the array, o-based
        int start = (count - 2) / 2;
        while (start >= 0) {
            percolateDown(array, start, count - 1);
            start--;
        }
    }

    // private method to repair the heap order (parent item is larger than its children)
    private static void percolateDown(Comparable[] array, int start, int end) {
        int root = start;
        int swap = root;
        while (2 * root + 1 <= end) { // check if it is not leaf node
            int childIndex = 2 * root + 1;
            swap = root;
            if (less(array[swap], array[childIndex])) swap = childIndex;
            if (childIndex + 1 <= end && less(array[swap], array[childIndex + 1])) swap = childIndex + 1;
            if (swap == root) {
                return;
            } else {
                swap(array, root, swap);
                root = swap;
            }
        }
    }

    // helper function for various sorting algorithm
    // swap two entrys in the array
    private static void swap(Comparable[] array, int i, int min) {
        Comparable temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }

    // helper function for various sorting algorithm
    // compare two entrys int the array
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

}
