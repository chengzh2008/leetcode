package src.main.java;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * Expected Time complexity is O(n) and only O(1) extra space can be used.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] num) {
        int max = num[0];
        int min = num[0];
        int maxProduct = num[0];

        for (int i = 1; i< num.length; i++) {
            int temp = max;
            // the second Math.max is considering either starting a new subarray or add to existing subarray.
            // the first Math.max is considering the negative num[i];
            max = Math.max(Math.max(num[i], max * num[i]), min * num[i]);
            min = Math.min(Math.min(num[i], min * num[i]), temp * num[i]);
            maxProduct = Math.max(maxProduct, max); // update the current maxProduct.
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] num = {3, 5, 2, -6, 8};
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(num));
    }
}
