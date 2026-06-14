class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        // return recursion(m, n)
        // return topDown(m, n)
        // return bottomUp(m,n)
        // return bottomUpSpaceOpt(m, n)
        return bottomUpSpaceOpt2(m, n)
    }

    fun recursion(m: Int, n: Int): Int {

        fun dfs(i: Int, j: Int): Int {
            if(i == m - 1 && j == n - 1) return 1

            if(i >= m || j >= n) return 0

            return dfs(i + 1, j) + dfs(i, j + 1)
        }

        return dfs(0, 0)
    }

    fun topDown(m: Int, n: Int): Int {
        val dp = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, j: Int): Int {
            if(Pair(i, j) in dp) return dp[Pair(i, j)]!!

            if(i == m - 1 && j == n - 1) return 1

            if(i >= m || j >= n) return 0

            dp[Pair(i, j)] = dfs(i + 1, j) + dfs(i, j + 1)

            return dp[Pair(i, j)]!!
        }

        return dfs(0, 0)
    }

    fun bottomUp(m: Int, n: Int): Int {
        val dp = Array(m) {
            IntArray(n) { 1 }
        }

        for(i in m - 2 downTo 0) {
            for(j in n - 2 downTo 0) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
            }
        }

        return dp[0][0]
    }

    fun bottomUpSpaceOpt(m: Int, n: Int): Int {
        var dp = IntArray(n) { 1 }

        for(i in m - 2 downTo 0) {
            val dp2 = IntArray(n) {1}
            for(j in n - 2 downTo 0) {
                dp2[j] = dp2[j + 1] + dp[j]
            }
            dp = dp2
        }

        return dp[0]
    }

    fun bottomUpSpaceOpt2(m: Int, n: Int): Int {
        val dp = IntArray(n) { 1 }

        for(i in m - 2 downTo 0) {
            for(j in n - 2 downTo 0) {
                dp[j] += dp[j + 1]
            }
        }

        return dp[0]
    }
}
