class Solution {
    fun rob(nums: IntArray): Int {
        // return backtracking(nums)
        return topDown(nums)
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
}
