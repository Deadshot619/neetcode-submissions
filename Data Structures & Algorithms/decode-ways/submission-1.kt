class Solution {
    fun numDecodings(s: String): Int {
        // return backtracking(s)
        return topDown(s)
    }

    fun backtracking(s: String): Int {
    
        fun dfs(i: Int): Int {
            if(i >= s.length) return 1

            if(s[i] == '0') return 0

            var total = dfs(i + 1)

            if(i + 1 < s.length){
                if(s[i] == '1' || (s[i] == '2' && s[i+1] < '7')){
                    total += dfs(i+2)
                }
            }

            return total
        }

        return dfs(0)
    }

    fun topDown(s: String): Int {
        val dp = mutableMapOf<Int, Int>()

        fun dfs(i: Int): Int {
            if(i >= s.length) return 1

            if(s[i] == '0') return 0

            if(i in dp) return dp[i]!!

            var total = dfs(i + 1)

            if(i + 1 < s.length){
                if(s[i] == '1' || (s[i] == '2' && s[i+1] < '7')){
                    total += dfs(i+2)
                }
            }

            dp[i] = total
            return dp[i]!!
        }

        return dfs(0)
    }
}
