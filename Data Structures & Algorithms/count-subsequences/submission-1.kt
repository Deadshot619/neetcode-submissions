class Solution {
    fun numDistinct(s: String, t: String): Int {
        // return backtracking(s, t)
        return topDown(s, t)
    }

    fun backtracking(s: String, t: String): Int {
        
        fun dfs(i: Int, j: Int): Int {
            if(j >= t.length) return 1

            if(i >= s.length) return 0

            
            var res = dfs(i + 1, j)
            if(s[i] == t[j]) {
                res += dfs(i + 1, j + 1)
            }

            return res
        }

        return dfs(0, 0)
    }

    fun topDown(s: String, t: String): Int {
        val dp = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, j: Int): Int {
            if(j >= t.length) return 1

            if(i >= s.length) return 0

            val key = Pair(i, j)

            if(key in dp) return dp[key]!!

            
            var res = dfs(i + 1, j)
            if(s[i] == t[j]) {
                res += dfs(i + 1, j + 1)
            }

            dp[key] = res

            return dp[key]!!
        }

        return dfs(0, 0)
    }
}
