/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        // return preorder(root)
        // return iterative(root)
        return iterative2(root)
    }

    fun preorder(root: TreeNode?): List<Int> {
        var res = mutableListOf<Int>()

        fun dfs(node: TreeNode?) {
            if(node == null) return

            res.add(node.`val`)
            dfs(node?.left)
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
                res.add(cur.`val`)
                stack.add(cur)
                cur = cur?.left
            }
            cur = stack.removeLast()
            cur = cur?.right
        }

        return res
    }

    fun iterative2(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        val stack = mutableListOf<TreeNode?>()
        var cur = root

        while (cur != null || stack.isNotEmpty()) {
            if (cur != null) {
                res.add(cur.`val`)
                stack.add(cur?.right)
                cur = cur.left
            } else {
                cur = stack.removeLast()
            }
        }

        return res
    }
}
