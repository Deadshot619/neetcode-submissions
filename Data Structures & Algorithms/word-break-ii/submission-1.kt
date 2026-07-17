class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        return backtracking(s, wordDict)
    }

    fun backtracking(s: String, wordDict: List<String>): List<String> {
        val res = mutableListOf<String>()
        val cur = mutableListOf<String>()

        val wordSet = wordDict.toSet()

        fun dfs(i: Int) {
            if(i >= s.length) {
                res.add(cur.joinToString(" "))
                return
            }

            for(j in i until s.length) {
                var substr = s.substring(i, j + 1)
                if(substr in wordSet) {
                    cur.add(substr)
                    dfs(j + 1)
                    cur.removeLast()
                }
            }
        }

        dfs(0)
        return res
    }
}
