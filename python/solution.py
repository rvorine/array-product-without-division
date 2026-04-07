"""
Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i]
is equal to the product of all elements of nums except nums[i].

Constraints:
    - O(n) time complexity
    - No division operator
    - O(1) extra space (output array is not counted as extra space)

Approach:
    1. Fill output[] with prefix products on a left-to-right pass.
    2. Multiply each position by its suffix product using a running variable
       on a right-to-left pass.
"""
from typing import List


def product_except_self(nums: List[int]) -> List[int]:
    n = len(nums)
    output = [1] * n

    # Left pass: output[i] holds the product of all elements to the left of i
    for i in range(1, n):
        output[i] = output[i - 1] * nums[i - 1]

    # Right pass: multiply output[i] by the product of all elements to the right of i
    suffix_product = 1
    for i in range(n - 1, -1, -1):
        output[i] *= suffix_product
        suffix_product *= nums[i]

    return output


if __name__ == "__main__":
    nums1 = [1, 2, 3, 4]
    print(f"Input: {nums1}  ->  Output: {product_except_self(nums1)}")  # Expected: [24, 12, 8, 6]

    nums2 = [-1, 1, 0, -3, 3]
    print(f"Input: {nums2}  ->  Output: {product_except_self(nums2)}")  # Expected: [0, 0, 9, 0, 0]
