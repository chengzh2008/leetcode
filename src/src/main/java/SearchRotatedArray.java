package src.main.java;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class SearchRotatedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        return searchInterative(A, target, 0, A.length - 1);
    }


    public int searchInterative(int[] arr, int target, int a, int b) {
        while (a <= b) {
            if (arr[a] == target) return a;
            if (arr[b] == target) return b;
            int mid = a + (b - a) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < arr[b]) {
                if (target > arr[mid] && target < arr[b]) {
                    a = mid + 1;
                    b--;
                } else {
                    a++;
                    b = mid - 1;
                }
            } else {
                if (target > arr[a] && target < arr[mid]) {
                    b = mid - 1;
                    a++;
                } else {
                    a = mid + 1;
                    b--;
                }

            }
        }
        return -1;
    }


    public int searchRecursive(int[] arr, int target, int a, int b) {
        if (b < a) return -1;
        if (a == b) {
            if (arr[a] == target) return a;
            else return -1;
        }
        if (arr[a] == target) return a;
        if (arr[b] == target) return b;
        int mid = a + (b - a) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < arr[b]) {
            if (target > arr[mid] && target < arr[b]) {
                return searchRecursive(arr, target, mid + 1, b - 1);
            } else {
                return searchRecursive(arr, target, a + 1, mid - 1);
            }
        } else {
            if (target > arr[a] && target < arr[mid]) {
                return searchRecursive(arr, target, a + 1, mid - 1);
            } else {
                return searchRecursive(arr, target, mid + 1, b - 1);
            }
        }
    }
}
