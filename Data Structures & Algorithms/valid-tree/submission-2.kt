class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if(n < 1) return true

        val adj = HashMap<Int, MutableList<Int>>()

        for(i in 0 until n) {
            adj[i] = mutableListOf<Int>()
        }

        // Nodes are undirected, so its a 2 way connection
        for((p, c) in edges) {
            adj[p]?.add(c)
            adj[c]?.add(p)
        }

        val visited = HashSet<Int>()

        fun dfs(e: Int, prev: Int): Boolean {
            if(e in visited) return false

            visited.add(e)

            for(n in adj[e] ?: listOf()) {
                // As its a 2 way connection, we won't 
                if(n == prev) continue  
                if(dfs(n, e).not()) return false
            }

            return true
        }

        return dfs(0, -1) && visited.size == n
    }
}
