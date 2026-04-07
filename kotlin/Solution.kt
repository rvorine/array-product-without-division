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
fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val output = IntArray(n)

    // Left pass: output[i] holds the product of all elements to the left of i
    output[0] = 1
    for (i in 1 until n) {
        output[i] = output[i - 1] * nums[i - 1]
    }

    // Right pass: multiply output[i] by the product of all elements to the right of i
    var suffixProduct = 1
    for (i in n - 1 downTo 0) {
        output[i] *= suffixProduct
        suffixProduct *= nums[i]
    }

    return output
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 4)
    val result1 = productExceptSelf(nums1)
    println("Input: [1, 2, 3, 4]  ->  Output: ${result1.toList()}") // Expected: [24, 12, 8, 6]

    val nums2 = intArrayOf(-1, 1, 0, -3, 3)
    val result2 = productExceptSelf(nums2)
    println("Input: [-1, 1, 0, -3, 3]  ->  Output: ${result2.toList()}") // Expected: [0, 0, 9, 0, 0]
}
