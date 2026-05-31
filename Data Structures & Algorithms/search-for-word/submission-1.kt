class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        // return backtracking(board, word)
        return backtracking2(board, word)
    }

    fun backtracking(board: Array<CharArray>, word: String): Boolean {
        val ROWS = board.size
        val COLS = board[0].size
        val visited = mutableSetOf<Pair<Int, Int>>()

        fun dfs(r: Int, c: Int, i: Int): Boolean {
            if(i == word.length) return true

            if(r < 0 || c < 0 || r >= ROWS || c >= COLS ||
                board[r][c] != word[i] || Pair(r, c) in visited){
                    return false
                }

            visited.add(Pair(r, c))

            val res = dfs(r + 1, c, i + 1) || dfs(r - 1, c, i + 1) ||
                dfs(r, c + 1, i + 1) || dfs(r, c - 1, i + 1)

            visited.remove(Pair(r, c))
            return res
        }

        for(r in 0 until ROWS){
            for(c in 0 until COLS){
                if(dfs(r, c, 0)){
                    return true
                }
            }
        }

        return false
    }

    fun backtracking2(board: Array<CharArray>, word: String): Boolean {
        val ROWS = board.size
        val COLS = board[0].size

        fun dfs(r: Int, c: Int, i: Int): Boolean {
            if(i == word.length) return true

            if(r < 0 || c < 0 || r >= ROWS || c >= COLS ||
                board[r][c] != word[i] || board[r][c] == '#'){
                    return false
                }

            val temp = board[r][c]
            board[r][c] = '#'

            val res = dfs(r + 1, c, i + 1) || dfs(r - 1, c, i + 1) ||
                dfs(r, c + 1, i + 1) || dfs(r, c - 1, i + 1)

            board[r][c] = temp
            return res
        }

        for(r in 0 until ROWS){
            for(c in 0 until COLS){
                if(dfs(r, c, 0)){
                    return true
                }
            }
        }

        return false
    }
}
