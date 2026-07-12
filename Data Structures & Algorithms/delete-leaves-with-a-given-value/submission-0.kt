/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        return postOrderDfs(root, target)
    }

    fun postOrderDfs(root: TreeNode?, target: Int): TreeNode? {

        fun dfs(node: TreeNode?): TreeNode? {
            if(node == null) return null

            node?.left = dfs(node.left)
            node?.right = dfs(node.right)

            if(node?.`val` == target) {
                if(node?.left == null && node?.right == null)
                    return null
            }  

            return node
        }

        
        return dfs(root)
    }
}
