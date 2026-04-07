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
#include <iostream>
#include <vector>

std::vector<int> productExceptSelf(const std::vector<int>& nums) {
    int n = static_cast<int>(nums.size());
    std::vector<int> output(n);

    // Left pass: output[i] holds the product of all elements to the left of i
    output[0] = 1;
    for (int i = 1; i < n; ++i) {
        output[i] = output[i - 1] * nums[i - 1];
    }

    // Right pass: multiply output[i] by the product of all elements to the right of i
    int suffixProduct = 1;
    for (int i = n - 1; i >= 0; --i) {
        output[i] *= suffixProduct;
        suffixProduct *= nums[i];
    }

    return output;
}

void printVector(const std::vector<int>& v) {
    std::cout << "[";
    for (int i = 0; i < static_cast<int>(v.size()); ++i) {
        std::cout << v[i];
        if (i < static_cast<int>(v.size()) - 1) std::cout << ", ";
    }
    std::cout << "]" << std::endl;
}

int main() {
    std::vector<int> nums1 = {1, 2, 3, 4};
    std::cout << "Input: [1, 2, 3, 4]  ->  Output: ";
    printVector(productExceptSelf(nums1)); // Expected: [24, 12, 8, 6]

    std::vector<int> nums2 = {-1, 1, 0, -3, 3};
    std::cout << "Input: [-1, 1, 0, -3, 3]  ->  Output: ";
    printVector(productExceptSelf(nums2)); // Expected: [0, 0, 9, 0, 0]

    return 0;
}
