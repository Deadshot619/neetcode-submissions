/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        return bfs(root)
    }

    fun bfs(root: TreeNode?): List<Int> {
        if(root == null) return listOf()

        val res = mutableListOf<Int>()

        val q = ArrayDeque<TreeNode>()
        q.addLast(root)

        while(q.isNotEmpty()) {
            val size = q.size

            for(i in 0 until size) {
                val node = q.removeFirst()

                if(i == size - 1)
                    res.add(node.`val`)

                node.left?.let {
                    q.addLast(it)
                }

                node.right?.let {
                    q.addLast(it)
                }
            }
        }

        return res
    }
}
