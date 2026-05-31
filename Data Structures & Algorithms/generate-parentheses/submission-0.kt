class Solution {
    fun generateParenthesis(n: Int): List<String> {
        return backtracking(n)
    }

    fun backtracking(n: Int): List<String> {
        val res = mutableListOf<String>()

        var cur = mutableListOf<Char>()

        fun dfs(o: Int, c: Int) { // open, close
            if(o == n && c == n) {
                res.add(cur.joinToString(""))
                return
            }

            if(o < n) {
                cur.add('(')
                dfs(o + 1, c)
                cur.removeLast()
            }

            if(c < o){
                cur.add(')')
                dfs(o, c + 1)
                cur.removeLast()
            }
        }

        dfs(0, 0)
        return res
    }
}
