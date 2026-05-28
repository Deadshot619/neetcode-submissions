/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(subRoot == null) return true

        if(root == null) return false
        
        if(isSameTree(root, subRoot))
            return true

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun isSameTree(t1: TreeNode?, t2: TreeNode?): Boolean {
        if(t1 == null && t2 == null) return true

        if(t1?.`val` != t2?.`val`) return false

        return isSameTree(t1?.left, t2?.left) && isSameTree(t1?.right, t2?.right)
    }
}
