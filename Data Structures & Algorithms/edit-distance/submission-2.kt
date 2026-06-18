class Solution {
    fun minDistance(word1: String, word2: String): Int {
        // return backtracking(word1, word2)
        return topDown(word1, word2)
    }

    fun backtracking(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length

        fun dfs(i: Int, j: Int): Int {
            if(i == m) return n - j
            if(j == n) return m - i
            if(word1[i] == word2[j]) return dfs(i + 1, j + 1)

            var res = minOf(
                dfs(i, j + 1), // Insert
                dfs(i + 1, j), // Delete
                dfs(i + 1, j + 1) // Replace
            )

            return res + 1
        }

        return dfs(0, 0)
    }

    fun topDown(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length

        val dp = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, j: Int): Int {
            if(i == m) return n - j
            if(j == n) return m - i

            val key = Pair(i, j)
            if(key in dp) return dp[key]!!

            if(word1[i] == word2[j]) return dfs(i + 1, j + 1)

            var res = minOf(
                dfs(i, j + 1), // Insert
                dfs(i + 1, j), // Delete
                dfs(i + 1, j + 1) // Replace
            )

            dp[key] = res + 1

            return dp[key]!!
        }

        return dfs(0, 0)
    }
}
