/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        return insertDFS(root, `val`)
    }

    fun insertDFS(root: TreeNode?, `val`: Int): TreeNode? {
        if(root == null) return TreeNode(`val`)
        
        fun dfs(node: TreeNode?, prevNode: TreeNode?): TreeNode? {
            if(node == null) {
                val n = TreeNode(`val`)
                if(`val` > prevNode?.`val` ?: 0)
                    prevNode?.right = n
                else
                    prevNode?.left = n
                return n
            }
            
            return if(`val` > node!!.`val`) {
                dfs(node?.right, node)
            } else {
                dfs(node?.left, node)
            }
        }

        dfs(root, null)
        return root
    }
}
