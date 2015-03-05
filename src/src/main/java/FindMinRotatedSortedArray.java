package src.main.java;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class FindMinRotatedSortedArray {
    public int findMin(int[] num) {
        int len = num.length;
        if (len == 0) return 0;
        return findMinhelper(num, 0, len - 1);
    }

    private int findMinhelper(int[] num, int l, int r) {
        if (l == r) return num[l]; // deal with a single element array
        if (l + 1 == r) return Math.max(num[l], num[r]); // deal with two elements array
        int mid = (l + r) / 2;
        if (num[mid-1] > num[mid]) return num[mid]; // hit directly the min element
        if (num[l] < num[mid] && num[mid] < num[r]) { // no rotation happened to the array
            return num[l];
        }
        if (num[mid] > num[r]) {
            return findMinhelper(num, mid, r);
        } else {
            return findMinhelper(num, l, mid);
        }
    }

    public static void main(String[] args) {
        FindMinRotatedSortedArray findMinRotatedSortedArray = new FindMinRotatedSortedArray();
        int[] num1 = {1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(findMinRotatedSortedArray.findMin(num1));
        int[] num2 = {6, 7, 8, 1, 2, 3, 4, 5};
        System.out.println(findMinRotatedSortedArray.findMin(num2));
        int[] num3 = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(findMinRotatedSortedArray.findMin(num3));
    }
}
