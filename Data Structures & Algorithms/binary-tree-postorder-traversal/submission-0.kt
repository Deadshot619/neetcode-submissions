/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        return postorder(root)
    }

    fun postorder(root: TreeNode?): List<Int> {
        var res = mutableListOf<Int>()

        fun dfs(node: TreeNode?) {
            if(node == null) return

            dfs(node?.left)
            dfs(node?.right)
            res.add(node.`val`)
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
                res.add(cur.`val`)
                stack.add(cur)
                cur = cur?.left
            }
            cur = stack.removeLast()
            cur = cur?.right
        }

        return res
    }
}
