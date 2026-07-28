class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        return adjBfs(equations, values, queries)
    }

    fun adjBfs(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val adj = HashMap<String, MutableList<Pair<String, Double>>>()

        for(i in 0 until equations.size) {
            val (s, e) = equations[i]
            val v = values[i]
            adj.getOrPut(s) {mutableListOf()}.add(Pair(e, v))
            adj.getOrPut(e) {mutableListOf()}.add(Pair(s, 1.0/v))
        }

        fun bfs(start: String, target: String): Double {
            if(start !in adj || target !in adj) return -1.0
            val q = ArrayDeque<Pair<String, Double>>()
            val visited = HashSet<String>()

            q.add(Pair(start, 1.0))

            while(q.isNotEmpty()) {
                repeat(q.size) {
                    val (node, dist) = q.removeFirst()
                    if(node == target) return dist

                    visited.add(node)

                    for((nei, d) in adj[node] ?: listOf()) {
                        if(nei in visited) continue
                        q.add(Pair(nei, d * dist))
                    }
                }
            }

            return -1.0
        }

        val res = DoubleArray(queries.size)
        for(i in 0 until queries.size) {
            val (s, t) = queries[i]
            res[i] = bfs(s, t)
        }
        return res
    }
}
