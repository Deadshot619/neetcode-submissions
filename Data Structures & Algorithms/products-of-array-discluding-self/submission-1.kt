class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        // return preAndPostFix(nums)
        return preAndPostFixOptimized(nums)
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

    fun preAndPostFixOptimized(nums: IntArray): IntArray {
        
        val result = IntArray(nums.size)
        var prefix = 1

        for(i in nums.indices) {
            result[i] = prefix
            prefix = prefix * nums[i]
        }

        var postfix = 1
        for(i in nums.size-1 downTo 0) {
            result[i] = result[i] * postfix
            postfix = nums[i] * postfix
        }

        return result
    }
}
