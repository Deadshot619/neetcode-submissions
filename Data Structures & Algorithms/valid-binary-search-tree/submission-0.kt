/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE)
    }

    fun checkNode(node: TreeNode?, left: Int, right: Int): Boolean {
        if(node == null)
            return true

        if(node.`val` <= left || node.`val` >= right)
            return false 

        return checkNode(node.left, left, node.`val`) && 
        checkNode(node.right, node.`val`, right)
    }
}
