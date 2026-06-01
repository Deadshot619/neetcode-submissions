class Solution {
    fun climbStairs(n: Int): Int {
        // return backtracking(n)
        // return topDown(n)
        // return bottomUp(n)
        return bottomUpOptimised(n)
    }

    fun backtracking(n: Int): Int {
        var res = 0

        fun dfs(i: Int) {
            if(i == n) {
                res++
                return
            }

            if( i > n) {
                return
            }

            dfs(i + 1)
            dfs(i + 2)
        }

        dfs(0)
        return res
    }

    fun topDown(n: Int): Int { // also called as memoisation
        val cache = hashMapOf<Int, Int>()

        fun dfs(i: Int): Int {
            if(i == n) return 1

            if(i > n) return 0

            if(i in cache) return cache[i]!!

            cache[i] = dfs(i + 1) + dfs(i + 2)

            return cache[i]!!
        }

        return dfs(0)
    }

    fun bottomUp(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 2

        for(i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }

    fun bottomUpOptimised(n: Int): Int {
        var one = 1
        var two = 1

        for(i in 0 until n - 1) {
            var temp = one
            one += two
            two = temp
        }

        return one
    }
}
