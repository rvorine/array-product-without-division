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

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function productExceptSelf(nums) {
    const n = nums.length;
    const output = new Array(n);

    // Left pass: output[i] holds the product of all elements to the left of i
    output[0] = 1;
    for (let i = 1; i < n; i++) {
        output[i] = output[i - 1] * nums[i - 1];
    }

    // Right pass: multiply output[i] by the product of all elements to the right of i
    let suffixProduct = 1;
    for (let i = n - 1; i >= 0; i--) {
        output[i] *= suffixProduct;
        suffixProduct *= nums[i];
    }

    return output;
}

const nums1 = [1, 2, 3, 4];
console.log(`Input: [${nums1}]  ->  Output: [${productExceptSelf(nums1)}]`); // Expected: [24, 12, 8, 6]

const nums2 = [-1, 1, 0, -3, 3];
console.log(`Input: [${nums2}]  ->  Output: [${productExceptSelf(nums2)}]`); // Expected: [0, 0, 9, 0, 0]
