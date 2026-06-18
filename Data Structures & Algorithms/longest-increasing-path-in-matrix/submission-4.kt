class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        // return backtracking(matrix)
        return topDown(matrix)
    }

    fun backtracking(matrix: Array<IntArray>): Int {
        val ROWS = matrix.size
        val COLS = matrix[0].size

        fun dfs(i: Int, j: Int, prev: Int): Int {
            if(i < 0 || i >= ROWS || j < 0 || j >= COLS )
                return 0

            if(matrix[i][j] <= prev)
                return 0
            
            val cur = matrix[i][j]

            return 1 + maxOf(
                dfs(i + 1, j, cur),
                dfs(i - 1, j, cur),
                dfs(i, j + 1, cur),
                dfs(i, j - 1, cur)
            )
            
        }

        var res = 0
        for(i in 0 until ROWS) {
            for(j in 0 until COLS) {
                res = maxOf(res, dfs(i, j, 0))
            }
        }

        return res
    }

    fun topDown(matrix: Array<IntArray>): Int {
        val ROWS = matrix.size
        val COLS = matrix[0].size

        val dp = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, j: Int, prev: Int): Int {
            if(i < 0 || i >= ROWS || j < 0 || j >= COLS )
                return 0

            if(matrix[i][j] <= prev)
                return 0
            
            val cur = matrix[i][j]
            val key = Pair(i, j)

            if(key in dp) return dp[key]!!

            dp[key] = 1 + maxOf(
                dfs(i + 1, j, cur),
                dfs(i - 1, j, cur),
                dfs(i, j + 1, cur),
                dfs(i, j - 1, cur)
            )

            return dp[key]!!
        }

        var res = 0
        for(i in 0 until ROWS) {
            for(j in 0 until COLS) {
                res = maxOf(res, dfs(i, j, Int.MIN_VALUE))
            }
        }

        return res
    }
}
