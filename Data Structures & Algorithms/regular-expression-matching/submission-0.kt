class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return backtracking(s, p)
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
}
