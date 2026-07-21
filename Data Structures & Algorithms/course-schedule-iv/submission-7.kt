class Solution {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        return depthFirstSearch(numCourses, prerequisites, queries)
    }

    fun depthFirstSearch(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        
        val adj = HashMap<Int, ArrayList<Int>>()
        for((u, v) in prerequisites) {
            if(u !in adj)
                adj[u] = arrayListOf<Int>()
            adj[u]?.add(v)
        }

        val prereq = HashMap<Int, HashSet<Int>>()

        fun dfs(c: Int): HashSet<Int> {
            if(c in prereq) return prereq[c]!!

            prereq[c] = HashSet<Int>()
            for(n in adj[c] ?: listOf()) {
                prereq[c]?.addAll(dfs(n))
            }
            prereq[c]?.add(c)
            return prereq[c]!!
        }

        for(i in 0 until numCourses) {
            dfs(i)
        }


        val res = mutableListOf<Boolean>()
        for((u, v) in queries) {
            res.add(v in prereq[u] ?: setOf())
        }

        return res
    }
}
