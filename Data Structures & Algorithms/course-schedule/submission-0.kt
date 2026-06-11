class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val preMap = HashMap<Int, MutableList<Int>>()

        for((crs, pre) in prerequisites) {
            if(preMap[crs] == null){
                preMap[crs] = mutableListOf<Int>()
            }
            preMap[crs]?.add(pre)
        }

        val visited = HashSet<Int>()

        fun dfs(crs: Int): Boolean {
            if(crs in visited) return false

            if(preMap[crs].isNullOrEmpty()) return true
            
            visited.add(crs)

            for(n in preMap[crs] ?: listOf()) {
                if(dfs(n).not()) {
                    return false
                }
            }

            preMap[crs] = mutableListOf()
            visited.remove(crs)
            return true
        }

        for(n in 0 until numCourses) {
            if(dfs(n).not())
                return false
        }

        return true
    }
}
