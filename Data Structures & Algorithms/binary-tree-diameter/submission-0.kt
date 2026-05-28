/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if(root == null) return 0

        var maxD = 0

        fun dfs(node: TreeNode?, h: Int): Int {
            if(node == null) return 0

            val left = dfs(node.left, 1)
            val right = dfs(node.right, 1)

            maxD = max(maxD, left + right)
            return h + max(left, right)
        }

        dfs(root, 1)
        return maxD
    }
}
