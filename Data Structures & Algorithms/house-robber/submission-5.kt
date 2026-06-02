class Solution {
    fun rob(nums: IntArray): Int {
        // return backtracking(nums)
        // return topDown(nums)
        return bottomUp(nums)
    }

    fun backtracking(nums: IntArray): Int {

        fun dfs(i: Int): Int {
            if(i >= nums.size) return 0

            return nums[i] + maxOf(dfs(i + 2), dfs(i + 3))
        }

        return maxOf(dfs(0), dfs(1))
    }

    fun topDown(nums: IntArray): Int {
        val cache = mutableMapOf<Int, Int>()
        
        fun dfs(i: Int): Int {
            if(i >= nums.size) return 0

            if(i in cache) return cache[i]!!
            
            cache[i] = nums[i] + maxOf(dfs(i + 2), dfs(i + 3))
            return cache[i]!!
        }

        return maxOf(dfs(0), dfs(1))
    }

    fun bottomUp(nums: IntArray): Int {
        if(nums.isEmpty()) return 0

        if(nums.size == 1) return nums[0]

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])

        for(i in 2 until nums.size) {
            dp[i] = maxOf(dp[i - 1], nums[i] + dp[i - 2])
        }

        return dp.last()
    }
}
