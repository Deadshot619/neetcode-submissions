class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        bfs(grid)
    }

    fun bfs(grid: Array<IntArray>) {
        val ROWS = grid.size
        val COLS = grid[0].size

        val visited = HashSet<Pair<Int, Int>>()
        val q = ArrayDeque<Pair<Int,Int>>()

        for(i in 0 until ROWS) {
            for(j in 0 until COLS) {
                if(grid[i][j] == 0) { // Add the treasure chest
                    q.addLast(Pair(i, j))
                    visited.add(Pair(i, j))
                }
            }
        }

        fun addPair(i: Int, j: Int) {
            if(i < 0 || i >= ROWS || j < 0 || j >= COLS || Pair(i,j) in visited || 
                grid[i][j] == -1)
                return

            q.addLast(Pair(i, j))
            visited.add(Pair(i, j))
        }

        var dist = 0
        while(q.isNotEmpty()) {
            repeat(q.size) {
                val (i, j) = q.removeFirst()
                grid[i][j] = dist
                
                addPair(i + 1, j)
                addPair(i - 1, j)
                addPair(i, j + 1)
                addPair(i, j - 1)
            }
            dist++
        }
    }
}
