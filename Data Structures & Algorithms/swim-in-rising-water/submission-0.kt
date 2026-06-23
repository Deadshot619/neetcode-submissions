class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        val N = grid.size
        val minHeap = PriorityQueue<IntArray>(compareBy{it[0]})
        val visit = mutableSetOf<Pair<Int, Int>>()
        val directions = listOf(
            Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1)
        )

        minHeap.offer(intArrayOf(grid[0][0], 0, 0)) // Time, r, c
        visit.add(Pair(0, 0)) // r, c

        while(minHeap.isNotEmpty()) {
            val (t, r, c) = minHeap.poll()

            if(r == N - 1 && c == N - 1)
                return t
            
            for((dr, dc) in directions) {
                val r1 = r + dr
                val c1 = c + dc
                if(r1 < 0 || c1 < 0 || r1 == N || c1 == N || 
                    Pair(r1, c1) in visit)
                    continue
                
                visit.add(Pair(r1, c1))
                minHeap.offer(
                    intArrayOf(maxOf(t, grid[r1][c1]), r1, c1)
                    )
            }
        }

        return -1
    }
}
