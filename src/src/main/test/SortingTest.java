package src.main.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.main.java.Sorter;

import java.util.Random;

public class SortingTest {

    private Comparable[] array;
    private int n = 10;
    private Random r;

    @Before
    public void setup() {
        r = new Random();
        array = new Comparable[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Integer(r.nextInt(100));
        }
    }

    @Test
    public void testSelectionSort() {
        Assert.assertFalse("should not be sorted", isSorted(array));
        Sorter.selectionSort(array);
        Assert.assertTrue("should be sorted", isSorted(array));
    }

    @Test
    public void testInsertionSort() {
        Assert.assertFalse("should not be sorted", isSorted(array));
        Sorter.insertionSort(array);
        Assert.assertTrue("should be sorted", isSorted(array));
    }

    @Test
    public void testMergeSort() {
        Assert.assertFalse("should not be sorted", isSorted(array));
        Sorter.mergeSort(array);
        Assert.assertTrue("should be sorted", isSorted(array));
    }

    @Test
    public void testQuickSort() {
        Assert.assertFalse("should not be sorted", isSorted(array));
        Sorter.quickSort(array);
        Assert.assertTrue("should be sorted", isSorted(array));
    }

    @Test
    public void testHeapSort() {
        Assert.assertFalse("should not be sorted", isSorted(array));
        Sorter.heapSort(array);
        Assert.assertTrue("should be sorted", isSorted(array));
    }

    private void printArray(Comparable[] a) {
        for (int i = 0; i< a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // test whether the array is sorted, empty is ordered.
    private static boolean isSorted(Comparable[] array) {
        for (int i = 1; i< array.length; i++) {
            if (Sorter.less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
