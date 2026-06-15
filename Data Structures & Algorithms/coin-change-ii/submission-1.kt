class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        // return recursion(amount, coins)
        return topDown(amount, coins)
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

        fun dfs(i: Int, curAmt: Int): Int {
            if(curAmt == amount) return 1
            if(i >= coins.size) return 0
            if(curAmt > amount) return 0
            if(Pair(i, curAmt) in dp) return dp[Pair(i, curAmt)]!!

            dp[Pair(i, curAmt)] = dfs(i, curAmt + coins[i]) + dfs(i + 1, curAmt)

            return dp[Pair(i, curAmt)]!!
        }

        return dfs(0, 0)
    }
}
