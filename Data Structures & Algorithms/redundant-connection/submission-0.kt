class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        return usingUnionFind(edges)
    }

    fun usingUnionFind(edges: Array<IntArray>): IntArray {
        // add +1 as we are using the nodes for indices and it starts from 1
        val parent = IntArray(edges.size + 1) { it }
        val rank = IntArray(edges.size + 1) { 1 }

        fun find(n: Int): Int {
            var cur = n

            while(cur != parent[cur]) {
                parent[cur] = parent[parent[cur]]
                cur = parent[cur]
            }

            return cur
        }

        fun union(e1: Int, e2: Int): Boolean {
            val p1 = find(e1)
            val p2 = find(e2)

            if(p1 == p2) return false

            if(rank[p2] > rank[p1]) {
                parent[p1] = p2
                rank[p2] += rank[p1]
            } else {
                parent[p2] = p1
                rank[p1] += rank[p2]
            }

            return true
        }

        for((e1, e2) in edges) {
            if(!union(e1, e2))
                return intArrayOf(e1, e2)
        }

        return intArrayOf(-1, -1)
    }
}
