class Solution {
    fun canJump(nums: IntArray): Boolean {
        // return backtracking(nums)
        // return topDown(nums)
        return greedy(nums)
    }

    fun backtracking(nums: IntArray): Boolean {

        fun dfs(i: Int): Boolean {
            if(i >= nums.size - 1)return true

            if(nums[i] == 0) return false

            var res = false

            for(j in 1..nums[i]) {
                res = res || dfs(i + j)
            }

            return res
        }

        return dfs(0)
    }
    
    fun topDown(nums: IntArray): Boolean {
        val dp = HashMap<Int, Boolean>()

        fun dfs(i: Int): Boolean {
            if(i >= nums.size - 1)return true

            if(nums[i] == 0) return false

            if(i in dp) return dp[i]!!

            var res = false

            for(j in 1..nums[i]) {
                res = res || dfs(i + j)
            }

            dp[i] = res
            return res
        }

        return dfs(0)
    }

    fun greedy(nums: IntArray): Boolean {
        var goal = nums.size - 1
        
        for(i in nums.size - 2 downTo 0) {
            if(i + nums[i] >= goal)
                goal = i
        }

        return goal == 0
    }
}
