class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        // return backtracking(cost)
        return topDown(cost)
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
}
