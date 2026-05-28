/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        // return maxDepthNoReturnValue(root)
        return maxDepthReturnValue(root)
    }

    fun maxDepthNoReturnValue(root: TreeNode?): Int {
        var maxHeight = 0

        fun dfs(node: TreeNode?, height: Int) {
            if(node == null)
                return

            maxHeight = max(maxHeight, height)
            dfs(node.left, height + 1)
            dfs(node.right, height + 1)
        }

        dfs(root, 1)
        return maxHeight
    }

    fun maxDepthReturnValue(root: TreeNode?): Int {
        if(root == null)
            return 0

        return 1 + max(
            maxDepthReturnValue(root.left),
            maxDepthReturnValue(root.right),
        )
    }
}
