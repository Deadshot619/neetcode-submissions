/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {

        fun dfs(node: TreeNode?, max: Int): Int {
            if(node == null)
                return 0

            var res = if(node.`val` >= max) 1 else 0
            val max = maxOf(node.`val`, max)

            res += dfs(node.left, max)
            res += dfs(node.right, max)

            return res
        }

        return dfs(root, root?.`val` ?: 0)
    }
}
