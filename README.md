[![Instagram](https://img.shields.io/badge/Instagram-%40lacopydepastel-E4405F?logo=instagram&logoColor=white)](https://www.instagram.com/lacopydepastel)
[![YouTube](https://img.shields.io/badge/YouTube-%40rvorine-FF0000?logo=youtube&logoColor=white)](https://www.youtube.com/@rvorine)

# Product of Array Except Self — Without Division

## Problem Statement

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the **product of all elements** of `nums` **except** `nums[i]`.

- You **must not** use the division operator.
- The solution must run in **O(n)** time.
- Use **O(1)** extra space (the output array itself does not count as extra space).

### Examples

| Input              | Output         |
|--------------------|----------------|
| `[1, 2, 3, 4]`     | `[24, 12, 8, 6]` |
| `[-1, 1, 0, -3, 3]` | `[0, 0, 9, 0, 0]` |

---

## Solution — Prefix & Suffix Products

### Intuition

For any index `i`:

```
answer[i] = (product of all elements to the LEFT of i)
           × (product of all elements to the RIGHT of i)
```

We can compute both parts in two linear passes without any extra array, using only a running product variable for the suffix.

### Algorithm (Two-Pass, O(1) Extra Space)

**Pass 1 — Left to Right (prefix products)**
Fill the output array so that `output[i]` holds the product of every element that appears *before* index `i`.

```
output[0] = 1
output[i] = output[i-1] * nums[i-1]   for i = 1 … n-1
```

**Pass 2 — Right to Left (suffix products)**
Maintain a running `suffixProduct` variable (starts at 1).  
Multiply each `output[i]` by `suffixProduct`, then update `suffixProduct`.

```
for i = n-1 … 0:
    output[i]    *= suffixProduct
    suffixProduct *= nums[i]
```

After both passes, `output[i]` contains the product of all elements except `nums[i]`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(n) |
| **Space** | O(1) extra (output array excluded) |

---

## Implementations

| Language | File |
|----------|------|
| Java | [`java/Solution.java`](java/Solution.java) |
| Kotlin | [`kotlin/Solution.kt`](kotlin/Solution.kt) |
| C++ | [`cpp/solution.cpp`](cpp/solution.cpp) |
| Python | [`python/solution.py`](python/solution.py) |
| JavaScript | [`javascript/solution.js`](javascript/solution.js) |

### Java
```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] output = new int[n];
    output[0] = 1;
    for (int i = 1; i < n; i++)
        output[i] = output[i - 1] * nums[i - 1];
    int suffixProduct = 1;
    for (int i = n - 1; i >= 0; i--) {
        output[i] *= suffixProduct;
        suffixProduct *= nums[i];
    }
    return output;
}
```

### Kotlin
```kotlin
fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val output = IntArray(n)
    output[0] = 1
    for (i in 1 until n) output[i] = output[i - 1] * nums[i - 1]
    var suffixProduct = 1
    for (i in n - 1 downTo 0) {
        output[i] *= suffixProduct
        suffixProduct *= nums[i]
    }
    return output
}
```

### C++
```cpp
vector<int> productExceptSelf(const vector<int>& nums) {
    int n = nums.size();
    vector<int> output(n);
    output[0] = 1;
    for (int i = 1; i < n; ++i)
        output[i] = output[i - 1] * nums[i - 1];
    int suffixProduct = 1;
    for (int i = n - 1; i >= 0; --i) {
        output[i] *= suffixProduct;
        suffixProduct *= nums[i];
    }
    return output;
}
```

### Python
```python
def product_except_self(nums: List[int]) -> List[int]:
    n = len(nums)
    output = [1] * n
    for i in range(1, n):
        output[i] = output[i - 1] * nums[i - 1]
    suffix_product = 1
    for i in range(n - 1, -1, -1):
        output[i] *= suffix_product
        suffix_product *= nums[i]
    return output
```

### JavaScript
```javascript
function productExceptSelf(nums) {
    const n = nums.length;
    const output = new Array(n);
    output[0] = 1;
    for (let i = 1; i < n; i++)
        output[i] = output[i - 1] * nums[i - 1];
    let suffixProduct = 1;
    for (let i = n - 1; i >= 0; i--) {
        output[i] *= suffixProduct;
        suffixProduct *= nums[i];
    }
    return output;
}
```

---

## Running the Code

**Java**
```bash
cd java
javac Solution.java
java Solution
```

**Kotlin**
```bash
cd kotlin
kotlinc Solution.kt -include-runtime -d Solution.jar
java -jar Solution.jar
```

**C++**
```bash
cd cpp
g++ -std=c++17 -o solution solution.cpp
./solution
```

**Python**
```bash
cd python
python solution.py
```

**JavaScript**
```bash
cd javascript
node solution.js
```
