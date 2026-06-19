class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        return usingBfsHeap(times, n, k)
    }

    // u -> Source Node
    // v -> Target Node
    // t -> Time/Weight to reach from u to v
    fun usingBfsHeap(times: Array<IntArray>, n: Int, k: Int): Int {
        val adj = HashMap<Int, MutableList<Pair<Int, Int>>>() // u -> MutableList(Pair(v, t))

        for((u, v, t) in times) {
            if(u !in adj)
                adj[u] = mutableListOf()
            adj[u]?.add(Pair(v, t))
        }

        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy {it.second})
        minHeap.add(Pair(k, 0))

        val visit = mutableSetOf<Int>()

        var time = 0

        while(minHeap.isNotEmpty()) {
            val (n, t) = minHeap.poll()

            if(n in visit) continue
            visit.add(n)
            time = maxOf(time, t)

            for((n1, t1) in adj[n] ?: listOf()) {
                // if(n1 in visit) continue
                minHeap.add(Pair(n1, t1 + t))
            }
        }

        return if(visit.size == n) time else -1
    }
}
