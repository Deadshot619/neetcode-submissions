class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        return selfSolution(n, edges)
    }

    fun selfSolution(n: Int, edges: Array<IntArray>): List<Int> {
        val adj = HashMap<Int, MutableList<Int>>()

        for(i in 0 until n) {
            adj[i] = mutableListOf()
        }
        
        for((a, b) in edges) {
            adj.getOrPut(a) {mutableListOf()}.add(b)
            adj.getOrPut(b) {mutableListOf()}.add(a)
        }

        fun getMaxDist(e: Int): Int {
            val visited = HashSet<Int>()

            fun dfs(n: Int, total: Int): Int {
                if(n in visited) return total

                visited.add(n)

                var res = total

                for(nei in adj[n]!!) {
                    if(nei in visited) continue
                    res = max(res, dfs(nei, total + 1))
                }

                return res
            }

            return dfs(e, 0)
        }

        val minH = PriorityQueue<Pair<Int, Int>>(compareBy{ it.second })
        for(i in 0 until n) {
            minH.add(Pair(i, getMaxDist(i)))
        }

        val res = mutableListOf<Pair<Int, Int>>()
        while(res.isEmpty() || 
        (minH.isNotEmpty() && res.last().second >= minH.peek()?.second ?: Integer.MAX_VALUE)) {
            res.add(minH.poll())
        }
        return res.map{it.first}
    }
}
