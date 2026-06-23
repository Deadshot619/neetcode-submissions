class Solution {
    fun jump(nums: IntArray): Int {
        // return backtracking(nums)
        return topDown(nums)
    }

    fun backtracking(nums: IntArray): Int {
        
        fun dfs(i: Int): Int {
            if(i >= nums.size - 1) return 0

            var res = Integer.MAX_VALUE

            for(j in 1..nums[i]) {
                res = min(res, 1 + dfs(i + j))
            }

            return res
        }

        return dfs(0)
    }

    fun topDown(nums: IntArray): Int {
        val dp = HashMap<Int, Int>()
        fun dfs(i: Int): Int {
            if(i >= nums.size - 1) return 0
            if(nums[i] == 0) return 1000000

            if(i in dp) return dp[i]!!

            var res = Integer.MAX_VALUE

            for(n in 1..nums[i]) {
                res = min(res, 1 + dfs(i + n))
            }

            dp[i] = res

            return res
        }

        return dfs(0)
    }
}
