class Solution {
    fun solve(board: Array<CharArray>) {
        val ROWS = board.size
        val COLS = board[0].size

        fun dfs(i: Int, j: Int) {
            if(i < 0 || i >= ROWS || j < 0 || j >= COLS || board[i][j] != 'O')
                return

            board[i][j] = 'T'
            dfs(i + 1, j)
            dfs(i - 1, j)
            dfs(i, j + 1)
            dfs(i, j - 1)
        }

        for(i in 0 until ROWS) {
            for(j in 0 until COLS) {
                if(i == 0 || i == ROWS - 1 || j == 0 || j == COLS - 1) {
                    if(board[i][j] == 'O')
                        dfs(i, j)
                }
            }   
        }

        for(i in 0 until ROWS) {
            for(j in 0 until COLS) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X'
                }

                if(board[i][j] == 'T') {
                    board[i][j] = 'O'
                }
            }   
        }
    }
}
