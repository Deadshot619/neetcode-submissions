class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        return backtracking(grid)
    }

    fun backtracking(grid: Array<IntArray>): Int {
        val ROWS = grid.size
        val COLS = grid[0].size

        val visited = mutableSetOf<Pair<Int, Int>>()

        fun dfs(r: Int, c: Int): Int {
            if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0)
                return 1
            if(Pair(r, c) in visited)
                return 0

            visited.add(Pair(r, c))

            return dfs(r + 1, c) + dfs(r - 1, c) + dfs(r, c + 1) + dfs(r, c - 1)
        }

        for(r in 0 until ROWS) {
            for(c in 0 until COLS) {
                if(grid[r][c] == 1)
                    return dfs(r, c)
            }
        }

        return 0
    }
}
