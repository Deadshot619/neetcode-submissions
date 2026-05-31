class Solution {
    fun partition(s: String): List<List<String>> {
        return backtracking(s)
    }

    fun backtracking(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()

        val cur = mutableListOf<String>()

        fun dfs(i: Int) {
            if(i >= s.length) {
                res.add(cur.toList())
                return
            }

            for(j in i until s.length) {
                if(isPalindrome(s, i, j)) {
                    cur.add(s.substring(i, j + 1))
                    dfs(j + 1)
                    cur.removeLast()
                }
            }
        }

        dfs(0)
        return res
    }

    fun isPalindrome(s: String, i: Int, j: Int): Boolean {
        var l = i
        var r = j

        while(l < r) {
            if(s[l] != s[r])
                return false
            l++
            r--
        }

        return true
    }
}
