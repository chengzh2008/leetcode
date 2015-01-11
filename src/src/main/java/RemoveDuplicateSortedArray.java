package src.main.java;

/**
 * Created by xiaoyazi on 1/10/15.
 * Given a sorted array, remove the duplicates in place such that each
 * element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place
 * with constant memory.
 *
 * For example,
 * Given input array A = [1,1,2],
 *
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicateSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }
        int insert = 1;
        int index = 1;
        while(index < A.length) {
            if (A[index] != A[insert-1]) {
                A[insert] = A[index];
                insert++;
            }
            index++;
        }
        return insert;
    }

    public static void main(String[] args) {
        RemoveDuplicateSortedArray s = new RemoveDuplicateSortedArray();
        int[] a = {3,2,2};
        System.out.println(s.removeDuplicates(a));
    }
}
