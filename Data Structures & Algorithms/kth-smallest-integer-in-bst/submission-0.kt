/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return preOrderDfs(root, k)
    }

    fun preOrderDfs(root: TreeNode?, k: Int): Int {
        val res = mutableListOf<Int>()

        fun dfs(node: TreeNode?) {
            if(node == null) return

            dfs(node.left)
            res.add(node.`val` ?: 0)
            dfs(node.right)
        }

        dfs(root)

        return res.getOrNull(k-1) ?: 0
    }
}
