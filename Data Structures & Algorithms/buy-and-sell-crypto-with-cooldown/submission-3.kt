class Solution {
    fun maxProfit(prices: IntArray): Int {
        // return recursion(prices)
        return topDown(prices)
    }

    fun recursion(prices: IntArray): Int {
        fun dfs(i: Int, buying: Boolean): Int {
            if(i >= prices.size) return 0

            val cooldown = dfs(i + 1, buying)

            return if(buying){
                val buy = dfs(i + 1, false) - prices[i]
                maxOf(buy, cooldown)
            } else {
                val sell = dfs(i + 2, true) + prices[i]
                maxOf(sell, cooldown)
            }
        }

        return dfs(0, true)
    }

    fun topDown(prices: IntArray): Int {
        val dp = HashMap<Pair<Int, Boolean>, Int>()

        fun dfs(i: Int, buying: Boolean): Int {
            if(i >= prices.size) return 0

            if(Pair(i, buying) in dp) return dp[Pair(i, buying)]!!

            val cooldown = dfs(i + 1, buying)

            dp[Pair(i, buying)] = if(buying){
                val buy = dfs(i + 1, false) - prices[i]
                maxOf(buy, cooldown)
            } else {
                val sell = dfs(i + 2, true) + prices[i]
                maxOf(sell, cooldown)
            }

            return dp[Pair(i, buying)]!!
        }

        return dfs(0, true)
    }
}
