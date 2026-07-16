class Solution {
    fun totalNQueens(n: Int): Int {
        return backtracking(n)
    }

    fun backtracking(n: Int): Int {
        var count = 0

        val col = HashSet<Int>()
        val posDiag = HashSet<Int>()
        val negDiag = HashSet<Int>()

        fun dfs(r: Int) {
            if(r == n) count++

            for(c in 0 until n) {
                if(c in col || (r + c) in posDiag || (r - c) in negDiag)
                    continue

                col.add(c)
                posDiag.add(r + c)
                negDiag.add(r - c)

                dfs(r + 1)

                col.remove(c)
                posDiag.remove(r + c)
                negDiag.remove(r - c)
            }
        }

        dfs(0)
        return count
    }    
}
