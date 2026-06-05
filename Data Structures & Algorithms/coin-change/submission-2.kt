class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        // return backtracking(coins, amount)
        // return topDown(coins, amount)
        return bottomUp(coins, amount)
    }

    fun backtracking(coins: IntArray, amount: Int): Int {
        
        val res = mutableListOf<Int>()
        var minSize = Integer.MAX_VALUE

        fun dfs(i: Int, total: Int) {
            if(total == amount) {
                minSize = minOf(res.size, minSize)
            }

            if(i >= coins.size || total > amount) return

            res.add(i)
            dfs(i, total + coins[i])

            res.removeLast()
            dfs(i + 1, total)
        }

        dfs(0, 0)
        return if(minSize == Integer.MAX_VALUE) -1 else minSize
    }

    fun topDown(coins: IntArray, amount: Int): Int {
        
        val memo = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, total: Int): Int {
            if (total == amount) return 0
            if (i >= coins.size || total > amount) return Int.MAX_VALUE

            val key = Pair(i, total)
            if (memo.containsKey(key)) return memo[key]!!

            // Choice 1: take coin[i]
            val take = dfs(i, total + coins[i])
            val takeResult = if (take == Int.MAX_VALUE) Int.MAX_VALUE else 1 + take

            // Choice 2: skip coin[i]
            val skip = dfs(i + 1, total)

            val result = minOf(takeResult, skip)
            memo[key] = result
            return result
        }

        val ans = dfs(0, 0)
        return if (ans == Int.MAX_VALUE) -1 else ans

    }

    fun bottomUp(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for(a in 1 until dp.size) { // a = amount
            for(c in coins) {   // c = coins
                if(a - c >= 0) {
                    dp[a] = minOf(dp[a], 1 + dp[a - c])
                }
            }
        }

        return if(dp[amount] > amount) -1 else dp[amount]
    }
}
