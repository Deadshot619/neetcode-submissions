class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        return bfs(grid)
    }

    fun bfs(grid: Array<IntArray>): Int {
        val ROWS = grid.size
        val COLS = grid[0].size

        val q = ArrayDeque<Pair<Int, Int>>()
        var freshFruit = 0

        for(i in 0 until ROWS) {
            for(j in 0 until COLS) {
                if(grid[i][j] == 1)
                    freshFruit++

                if(grid[i][j] == 2)
                    q.addLast(Pair(i,j))
            }
        }

        val visited = HashSet<Pair<Int, Int>>()
        var time = 0
        
        fun addPair(i: Int, j: Int) {
            if(i < 0 || i >= ROWS || j < 0 || j >= COLS || 
                Pair(i,j) in visited || grid[i][j] in setOf(0, 2))
                return

            freshFruit--
            grid[i][j] = 2
            visited.add(Pair(i, j))
            q.addLast(Pair(i, j))
        }

        while(freshFruit > 0 && q.isNotEmpty()) {
            repeat(q.size) {
                val (i, j) = q.removeFirst()

                addPair(i + 1, j)
                addPair(i - 1, j)
                addPair(i, j + 1)
                addPair(i, j - 1)
            }
            time++
        }

        return if(freshFruit > 0) -1 else time
    }
}
