class Solution {
    fun rob(nums: IntArray): Int {
        // return backtracking(nums)
        // return topDown(nums)
        return bottomUpOptimized(nums)
    }

    fun bottomUpOptimized(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        return maxOf(
            nums[0],
            robOne(nums.sliceArray(0..nums.size - 2)),
            robOne(nums.sliceArray(1..nums.size - 1))
        )
    }

    private fun robOne(nums: IntArray): Int {
        var rob1 = 0
        var rob2 = 0

        for(n in nums) {
            val temp = maxOf(rob2, rob1 + n)
            rob1 = rob2
            rob2 = temp
        }

        return rob2
    }
}
