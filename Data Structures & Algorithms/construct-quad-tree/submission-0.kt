/*
// Definition for a QuadTree node.
class Node(
    var `val`: Boolean = false,
    var isLeaf: Boolean = false,
    var topLeft: Node? = null,
    var topRight: Node? = null,
    var bottomLeft: Node? = null,
    var bottomRight: Node? = null
)
*/

class Solution {
    fun construct(grid: Array<IntArray>): Node? {
        fun dfs(n: Int, r: Int, c: Int): Node {
            var allSame = true

            for(i in 0 until n) {
                for(j in 0 until n) {
                    if(grid[r][c] != grid[r + i][c + j]){
                        allSame = false
                        break
                    }
                }
            }

            if(allSame) {
                return Node(grid[r][c] == 1, true)
            }

            val mid = n/2
            val topLeft = dfs(mid, r, c)
            val topRight = dfs(mid, r, c + mid)
            val bottomLeft = dfs(mid, r + mid, c)
            val bottomRight = dfs(mid, r + mid, c + mid)

            return Node(false, false).apply {
                this.topLeft = topLeft
                this.topRight = topRight
                this.bottomLeft = bottomLeft
                this.bottomRight = bottomRight
            }
        }

        return dfs(grid[0].size, 0, 0)
    }
}
