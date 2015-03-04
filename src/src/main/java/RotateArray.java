package src.main.java;

/**
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * [show hint]
 * <p>
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Credits:
 * Special thanks to @Freezen for adding this problem and creating all test cases.
 */
public class RotateArray {
    public void rotateJuggling(int[] arr, int d) {
        int n = arr.length;
        // edge cases
        if (d % n ==0) return;
        // reduce d to less than n
        while(d > n) {
            d = d - n;
        }
        // d is the number steps to rotate the array
        int set_size = gcd(n, n-d);
        for (int i = 0; i < set_size; i++) {
            int temp = arr[i];
            int j = i;
            int k;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    private int gcd(int n, int d) {
        if (d == 0) return n;
        else {
            return gcd(d, n % d);
        }
    }


    public String toString(int[] arr) {
        String out = "";
        for (int i : arr) {
            out = out + i + " ";
        }
        return out;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotateJuggling(arr, 2);
        System.out.println("args = [" + rotateArray.toString(arr) + "]");
    }
}
