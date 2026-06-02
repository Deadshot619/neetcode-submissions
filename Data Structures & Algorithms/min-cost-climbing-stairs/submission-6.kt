class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        // return backtracking(cost)
        // return topDown(cost)
        // return bottomUp(cost)
        return bottomUpOptimized(cost)
    }

    fun backtracking(cost: IntArray): Int {
        
        fun dfs(i: Int): Int {
            if(i >= cost.size) return 0

            return cost[i] + minOf(dfs(i + 1), dfs(i + 2))
        }

        return minOf(dfs(0), dfs(1))
    }

    fun topDown(cost: IntArray): Int {
        val cache = mutableMapOf<Int, Int>()

        fun dfs(i: Int): Int {
            if(i >= cost.size) return 0

            if(i in cache) return cache[i]!!

            cache[i] = cost[i] + minOf(dfs(i + 1), dfs(i + 2))

            return cache[i]!!
        }

        return minOf(dfs(0), dfs(1))
    }

    fun bottomUp(cost: IntArray): Int {
        val dp = IntArray(cost.size + 1)

        for(i in 2 until dp.size) {
            dp[i] = minOf(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2])
        }

        return dp.last()
    }

    fun bottomUpOptimized(cost: IntArray): Int {
        val n = cost.size

        for(i in n - 3 downTo 0) {
            // cost[i] = minOf(cost[i] + cost[i + 1], cost[i] + cost[i + 2])
            cost[i] += minOf(cost[i + 1], cost[i + 2])
        }

        return minOf(cost[0], cost[1])
    }
}
