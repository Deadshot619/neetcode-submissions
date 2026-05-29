/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        return BFS(root)
    }

    fun BFS(root: TreeNode?): List<List<Int>> {
        if(root == null) return listOf()

        val res = mutableListOf<List<Int>>()

        val q = ArrayDeque<TreeNode>()
        q.addLast(root)

        while(q.isNotEmpty()) {
            val size = q.size
            val temp = mutableListOf<Int>()

            repeat(size) {
                val node = q.removeFirst()
                temp.add(node.`val`)

                node.left?.let{
                    q.addLast(it)
                }

                node.right?.let{
                    q.addLast(it)
                }
            }

            res.add(temp.toList())
        }

        return res
    }
}
