class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val adj = HashMap<Int, MutableList<Pair<Int, Int>>>()

        for(i in 0 until points.size) {
            if(i !in adj)
                adj[i] = mutableListOf()
        }

        for(i in 0 until points.size) {
            val (x1, y1) = points[i]
            for(j in i + 1 until points.size) {
                val (x2, y2) = points[j]
                val dist = Math.abs(x2 - x1) + Math.abs(y2 - y1)
                adj[i]?.add(Pair(dist, j))
                adj[j]?.add(Pair(dist, i))
            }
        }

        val visit = mutableSetOf<Int>()
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy{it.first}) // Frontier
        minHeap.offer(Pair(0, 0))
        
        var cost = 0

        while(visit.size < points.size) {
            val (d, p) = minHeap.poll()
            
            if(p in visit) continue
            
            visit.add(p)
            cost += d

            for((d1, p1) in adj[p] ?: listOf()) {
                if(p1 in visit) continue
                minHeap.offer(Pair(d1, p1))
            }
        }

        return cost
    }
}
