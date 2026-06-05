class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // return backtracking(s, wordDict)
        // return topDown(s, wordDict)
        return bottomUp(s, wordDict)
    }

    fun backtracking(s: String, wordDict: List<String>): Boolean {

        fun dfs(i: Int): Boolean {
            if(i >= s.length) return true

            var res = false
            for(w in wordDict) {
                val lastIndex = i + w.length
                if(lastIndex <= s.length && w == s.substring(i, lastIndex))
                    res = res || dfs(i + lastIndex)
            }

            return res
        }

        return dfs(0)
    }

    fun topDown(s: String, wordDict: List<String>): Boolean {
        val dp = HashMap<Int, Boolean>()
        fun dfs(i: Int): Boolean {
            if(i >= s.length) return true

            if(i in dp) return dp[i]!!

            for(w in wordDict) {
                val lastIndex = i + w.length
                if(lastIndex <= s.length && w == s.substring(i, lastIndex)){
                    if(dfs(lastIndex)){
                        dp[i] = true
                        return true
                    }
                }
            }

            dp[i] = false

            return false
        }

        return dfs(0)
    }

    fun bottomUp(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1){ false }
        dp[s.length] = true

        for(i in s.length - 1 downTo 0) {
            for(w in wordDict){
                val lastIndex = i + w.length
                if(lastIndex <= s.length && w == s.substring(i, lastIndex)) {
                    dp[i] = dp[lastIndex]
                }
                if(dp[i]) 
                    break
            }
        }

        return dp[0]
    }
}
