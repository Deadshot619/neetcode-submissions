/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        
        var isBalanced = true

        fun dfs(node: TreeNode?): Int {
            if(node == null) return 0

            val left = dfs(node.left)
            val right = dfs(node.right)

            if(Math.abs(left - right) > 1 && isBalanced)
                isBalanced = false

            return 1 + max(left, right)
        }

        dfs(root)
        return isBalanced
    }
}
