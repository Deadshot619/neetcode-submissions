class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adj = HashMap<Int, MutableList<Int>>()

        for((crs, pre) in prerequisites) {
            if(crs !in adj) {
                adj[crs] = mutableListOf<Int>()
            }
            adj[crs]?.add(pre)
        }

        val visiting = HashSet<Int>() // to detect cycle
        val visited = HashSet<Int>()
        val res = mutableListOf<Int>()

        fun dfs(crs: Int): Boolean {
            if(crs in visiting) return false

            if(crs in visited) return true

            visiting.add(crs)

            for(pre in adj[crs] ?: listOf()) {
                if(dfs(pre).not())
                    return false
            }

            visiting.remove(crs)
            visited.add(crs)
            res.add(crs)
            return true
        }

        for(c in 0 until numCourses) {
            if(dfs(c).not())
                return intArrayOf()
        }

        return res.toIntArray()
    }
}
