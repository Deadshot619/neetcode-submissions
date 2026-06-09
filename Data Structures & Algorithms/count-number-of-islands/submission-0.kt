class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val ROWS = grid.size
        val COLS = grid[0].size

        fun dfs(i: Int, j: Int) {
            if(i < 0 || i >= ROWS || j < 0 || j >= COLS || grid[i][j] == '0')
                return

            grid[i][j] = '0'
            dfs(i + 1, j)
            dfs(i - 1, j)
            dfs(i, j + 1)
            dfs(i, j - 1)
        }

        var res = 0

        for(i in 0 until ROWS) {
            for(j in 0 until COLS) {
                if(grid[i][j] == '1'){
                    dfs(i, j)
                    res++
                }
            }
        }
    
        return res
    }
}
