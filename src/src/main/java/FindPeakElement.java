package src.main.java;

/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        if (num.length <= 1) return 0;
        int l = 0, r = num.length - 1, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (num[mid] > num[mid + 1]) {
                r = mid;
            } else if (num[mid] < num[mid + 1]) {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] num = {1, 3, 5, 7, 5};
        System.out.println(findPeakElement.findPeakElement(num));
    }
}
