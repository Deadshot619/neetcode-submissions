/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rob(root: TreeNode?): Int {
        return postOrderDfs(root)
    }

    fun postOrderDfs(root: TreeNode?): Int {

        // Pair(withRoot, withoutRoot)
        fun dfs(node: TreeNode?): Pair<Int, Int>{
            if(node == null) return Pair(0, 0)

            val left = dfs(node?.left)
            val right = dfs(node?.right)

            val withRoot = node.`val` + left.second + right.second
            val withoutRoot = maxOf(left.first, left.second) + maxOf(right.first, right.second)

            return Pair(withRoot, withoutRoot)
        }

        val res = dfs(root)
        return maxOf(res.first, res.second)
    }
}
