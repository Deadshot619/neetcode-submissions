class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        return backtracking(n)
    }

    fun backtracking(n: Int): List<List<String>> {
        val res = mutableListOf<List<String>>()

        val colSet = mutableSetOf<Int>()
        val posDiagSet = mutableSetOf<Int>()
        val negDiagSet = mutableSetOf<Int>()

        val board = MutableList(n){
            MutableList(n){
                '.'
            }
        }

        fun dfs(r: Int) {
            if(r == n) {
                res.add(board.map{
                    it.joinToString("")
                })
                return
            }

            for(c in 0 until n) {
                if(c in colSet || (r + c) in posDiagSet || (r - c) in negDiagSet) {
                    continue
                }

                colSet.add(c)
                posDiagSet.add(r + c)
                negDiagSet.add(r - c)
                board[r][c] = 'Q'

                dfs(r + 1)

                colSet.remove(c)
                posDiagSet.remove(r + c)
                negDiagSet.remove(r - c)
                board[r][c] = '.'
            }
        }

        dfs(0)
        return res
    }
}
