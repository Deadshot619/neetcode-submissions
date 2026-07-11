/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        // return inorder(root)
        return iterative(root)
    }

    fun inorder(root: TreeNode?): List<Int> {
        var res = mutableListOf<Int>()

        fun dfs(node: TreeNode?) {
            if(node == null) return

            dfs(node?.left)
            res.add(node.`val`)
            dfs(node?.right)
        }

        dfs(root)
        return res
    }

    fun iterative(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        val stack = mutableListOf<TreeNode>()
        var cur: TreeNode? = root

        while(cur != null || stack.isNotEmpty()) {
            while(cur != null) {
                stack.add(cur)
                cur = cur?.left
            }
            val node = stack.removeLast()
            res.add(node.`val`)
            cur = node?.right
        }

        return res
    }
}
