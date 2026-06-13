class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        // return usingDfs(n, edges)
        return unionFind(n, edges)
    }

    fun usingDfs(n: Int, edges: Array<IntArray>): Int {
        val adj = HashMap<Int, MutableList<Int>>()
        val visited = BooleanArray(n)

        for(i in 0 until n) {
            adj[i] = mutableListOf<Int>()
        }

        for((e1, e2) in edges) {
            adj[e1]?.add(e2)
            adj[e2]?.add(e1)
        }

        fun dfs(n: Int) {
            if(visited[n]) return

            visited[n] = true

            for(e in adj[n] ?: listOf()) {
                dfs(e)
            }
        }

        var res = 0
        for(e in 0 until n) {
            if(!visited[e]) {
                dfs(e)
                res++
            }
        }

        return res
    }

    fun unionFind(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        val rank = IntArray(n) { 1 }

        fun find(n: Int): Int {
            var cur = n

            while(cur != parent[cur]) {
                parent[cur] = parent[parent[cur]]
                cur = parent[cur]
            }

            return cur
        }

        fun union(n1: Int, n2: Int): Int {
            var p1 = find(n1)
            var p2 = find(n2)

            if(p1 == p2) return 0

            if(rank[p2] > rank[p1]) {
                parent[p1] = p2
            } else {
                parent[p2] = p1
            }

            return 1
        }

        var res = n
        for((e1, e2) in edges) {
            res = res - union(e1, e2)
        }

        return res
    }
}
