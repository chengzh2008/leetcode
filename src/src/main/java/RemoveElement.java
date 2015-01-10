package src.main.java;

/**
 * Created by xiaoyazi on 1/10/15.
 * Given an array and a value, remove all instances of that value in place
 * and return the new length.
 *
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) return 0;
        int count = 0;
        int index = A.length-1;
        int last = A.length-1;
        while(index >=0) {
            if(A[index] == elem) {
                A[index] = A[last];
                last--;
            }
            index--;
        }
        return last+1;
    }
}
