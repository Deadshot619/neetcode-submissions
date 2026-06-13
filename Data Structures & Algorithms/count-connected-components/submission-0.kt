class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        return usingDfs(n, edges)
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
                if(!visited[e]) {
                    dfs(e)
                }
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
}
