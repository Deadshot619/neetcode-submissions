class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        return bottomUp(m,n)
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
}
