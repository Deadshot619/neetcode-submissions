class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        // return recursion(text1, text2)
        // return topDown(text1, text2)
        // return bottomUp(text1, text2)
        return bottomUpSpaceOpt(text1, text2)
    }

    fun recursion(text1: String, text2: String): Int {

        fun dfs(i: Int, j: Int): Int {
            if(i >= text1.length || j >= text2.length)
                return 0

            return if(text1[i] == text2[j]) {
                1 + dfs(i + 1, j + 1)
            } else {
                maxOf(dfs(i + 1, j), dfs(i, j + 1))
            }
        }

        
        return dfs(0, 0)
    }

    fun topDown(text1: String, text2: String): Int {
        val dp = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, j: Int): Int {
            if(i >= text1.length || j >= text2.length)
                return 0
            
            if(Pair(i, j) in dp) return dp[Pair(i, j)]!!

            dp[Pair(i, j)] = if(text1[i] == text2[j]) {
                1 + dfs(i + 1, j + 1)
            } else {
                maxOf(dfs(i + 1, j), dfs(i, j + 1))
            }

            return dp[Pair(i, j)]!!
        }

        
        return dfs(0, 0)
    }

    fun bottomUp(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val dp = Array(m + 1) {
            IntArray(n + 1) { 0 }
        }

        for(i in m - 1 downTo 0) {
            for(j in n - 1 downTo 0) {
                dp[i][j] = if(text1[i] == text2[j]) {
                    1 + dp[i + 1][j + 1]
                } else {
                    maxOf(dp[i + 1][j], dp[i][j + 1])
                }
            }
        }

        return dp[0][0]
    }

    fun bottomUpSpaceOpt(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        var prev = IntArray(n + 1) { 0 }

        for(i in m - 1 downTo 0) {
            var cur = IntArray(n + 1) { 0 }
            for(j in n - 1 downTo 0) {
                cur[j] = if(text1[i] == text2[j]) {
                    1 + prev[j + 1]
                } else {
                    maxOf(cur[j + 1], prev[j])
                }
            }
            prev = cur
        }

        return prev[0]
    }
}
