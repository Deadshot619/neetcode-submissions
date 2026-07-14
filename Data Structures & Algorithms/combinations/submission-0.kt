class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        return backtracking(n, k)
    }

    fun backtracking(n: Int, k: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        var cur = mutableListOf<Int>()

        fun dfs(i: Int) {
            if(i > n) {
                if(cur.size == k)
                    res.add(cur.toList())
                return
            }

            cur.add(i)
            dfs(i + 1)

            cur.removeLast()
            dfs(i + 1)
        }

        dfs(1)
        return res
    }
}
