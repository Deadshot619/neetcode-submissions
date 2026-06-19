class Solution {
    fun isMatch(s: String, p: String): Boolean {
        // return backtracking(s, p)
        return topDown(s, p)
    }

    fun backtracking(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length

        fun dfs(i: Int, j: Int): Boolean {
            if(i >= m && j >= n) return true

            if(j >= n) return false

            val match = i < m && (s[i] == p[j] || p[j] == '.')

            if(j + 1 < n && p[j + 1] == '*'){
                return (match && dfs(i + 1, j)) || dfs(i, j + 2)
            }

            if(match) {
                return dfs(i + 1, j + 1)
            }

            return false
        }

        return dfs(0, 0)
    }

    fun topDown(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length

        val dp = HashMap<Pair<Int, Int>, Boolean>()

        fun dfs(i: Int, j: Int): Boolean {
            if(i >= m && j >= n) return true

            if(j >= n) return false

            val key = Pair(i, j)
            if(key in dp) return dp[key]!!

            val match = i < m && (s[i] == p[j] || p[j] == '.')

            if(j + 1 < n && p[j + 1] == '*'){
                dp[key] = (match && dfs(i + 1, j)) || dfs(i, j + 2)
                return dp[key]!!
            }

            if(match) {
                dp[key] = dfs(i + 1, j + 1)
                return dp[key]!!
            }

            dp[key] = false
            return false
        }

        return dfs(0, 0)
    }
}
