/**
 * Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all elements of nums except nums[i].
 *
 * Constraints:
 *  - O(n) time complexity
 *  - No division operator
 *  - O(1) extra space (output array is not counted as extra space)
 *
 * Approach:
 *  1. Fill output[] with prefix products on a left-to-right pass.
 *  2. Multiply each position by its suffix product using a running variable
 *     on a right-to-left pass.
 */
public class Solution {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Left pass: output[i] holds the product of all elements to the left of i
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Right pass: multiply output[i] by the product of all elements to the right of i
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        System.out.print("Input: [1, 2, 3, 4]  ->  Output: ");
        printArray(result1); // Expected: [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        System.out.print("Input: [-1, 1, 0, -3, 3]  ->  Output: ");
        printArray(result2); // Expected: [0, 0, 9, 0, 0]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
