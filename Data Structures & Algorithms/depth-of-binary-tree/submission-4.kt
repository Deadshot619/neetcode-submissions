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
        // return maxDepthReturnValue(root)
        // return usingStackDFS(root)
        return usingQueueBFS(root)
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

    fun usingStackDFS(root: TreeNode?): Int {
        if(root == null) return 0

        var maxH = 0
        val stack = ArrayDeque<Pair<TreeNode, Int>>()
        stack.addLast(Pair(root, 1))

        while(stack.isNotEmpty()) {
            val (node, h) = stack.removeLast()

            maxH = max(maxH, h)
            node.left?.let {
                stack.addLast(Pair(it, h + 1))
            }
            node.right?.let {
                stack.addLast(Pair(it, h + 1))
            }
        }

        return maxH
    }

    fun usingQueueBFS(root: TreeNode?): Int {
        if(root == null) return 0

        val q = ArrayDeque<TreeNode>()
        q.addLast(root)

        var level = 0

        while(q.isNotEmpty()) {
            val size = q.size

            repeat(size) {
                val node = q.removeFirst()
                
                node.left?.let { q.addLast(it) }
                node.right?.let { q.addLast(it)}
            }

            level++
        }

        return level
    }
}
