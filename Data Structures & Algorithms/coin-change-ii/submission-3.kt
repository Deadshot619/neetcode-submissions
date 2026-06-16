class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        // return recursion(amount, coins)
        // return topDown(amount, coins)
        // return bottomUp(amount, coins)
        return bottomUpSpaceOpt(amount, coins)
    }

    fun recursion(amount: Int, coins: IntArray): Int {
        
        fun dfs(i: Int, curAmt: Int): Int {
            if(curAmt == amount) return 1
            if(i >= coins.size) return 0
            if(curAmt > amount) return 0

            return dfs(i, curAmt + coins[i]) + dfs(i + 1, curAmt)    
        }

        return dfs(0, 0)
    }

    fun topDown(amount: Int, coins: IntArray): Int { // T: O(m*n), S: O(m*n)
        val dp = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, a: Int): Int {
            if(a == amount) return 1
            if(i >= coins.size) return 0
            if(a > amount) return 0
            if(Pair(i, a) in dp) return dp[Pair(i, a)]!!

            dp[Pair(i, a)] = dfs(i, a + coins[i]) + dfs(i + 1, a)

            return dp[Pair(i, a)]!!
        }

        return dfs(0, 0)
    }

    fun bottomUp(amount: Int, coins: IntArray): Int { // T: O(m*n), S: O(m*n)
        val dp = Array(coins.size) {
            IntArray(amount + 1){1}
        }

        for(c in coins.size - 1 downTo 0) {
            for(a in 1..amount) {
                dp[c][a] = if(c + 1 < coins.size)
                    dp[c + 1][a]
                else 
                    0   // For last row

                if(a - coins[c] >= 0)
                    dp[c][a] += dp[c][a - coins[c]]
            }
        }


        return dp[0][amount]
    }

    fun bottomUpSpaceOpt(amount: Int, coins: IntArray): Int { // T: O(m*n), S: O(m*n)
        var dp = IntArray(amount + 1)
        dp[0] = 1

        for(c in coins.size - 1 downTo 0) {
            val nextDp = IntArray(amount + 1)
            nextDp[0] = 1

            for(a in 1..amount) {
                nextDp[a] = dp[a]

                if(a - coins[c] >= 0)
                    nextDp[a] += nextDp[a - coins[c]]
            }

            dp = nextDp
        }

        return dp[amount]
    }
}
