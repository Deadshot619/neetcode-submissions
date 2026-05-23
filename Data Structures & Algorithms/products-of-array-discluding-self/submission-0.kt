class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        return preAndPostFix(nums)
    }

    fun preAndPostFix(nums: IntArray): IntArray {
        val prefix = IntArray(nums.size)
        nums.forEachIndexed{ i, n ->
            prefix[i] = (prefix.getOrNull(i-1) ?: 1) * n
        }

        val postfix = IntArray(nums.size)
        for(i in nums.size-1 downTo 0) {
            postfix[i] = (postfix.getOrNull(i+1) ?: 1) * nums[i]
        }

        val result = IntArray(nums.size)
        nums.forEachIndexed { i, _ ->
            result[i] = (prefix.getOrNull(i-1) ?: 1) * (postfix.getOrNull(i+1) ?: 1)
        }

        return result
    }
}
