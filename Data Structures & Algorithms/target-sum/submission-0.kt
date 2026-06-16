class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        return backtracking(nums, target)
        return topDown(nums, target)
    }

    fun backtracking(nums: IntArray, target: Int): Int {

        fun dfs(i: Int, t: Int): Int {
            if(i == nums.size) {
                if(t == target)
                    return 1
                else return 0
            }

            return dfs(i + 1, t + nums[i]) + dfs(i + 1, t - nums[i])
        }

        return dfs(0, 0)
    }

    fun topDown(nums: IntArray, target: Int): Int {
        val dp = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, t: Int): Int {
            if(i == nums.size) {
                if(t == target)
                    return 1
                else 
                    return 0
            }

            if(Pair(i, t) in dp) return dp[Pair(i, t)]!!

            dp[Pair(i, t)] = dfs(i + 1, t + nums[i]) + dfs(i + 1, t - nums[i])
            return dp[Pair(i, t)]!!
        }

        return dfs(0, 0)
    }
}
