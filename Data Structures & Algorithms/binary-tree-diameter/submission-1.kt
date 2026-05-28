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

        fun dfs(node: TreeNode?): Int {
            if(node == null) return 0

            val left = dfs(node.left)
            val right = dfs(node.right)

            maxD = max(maxD, left + right)
            return 1 + max(left, right)
        }

        dfs(root)
        return maxD
    }
}
