/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val res = mutableListOf<String>()

        fun dfs(node: TreeNode?) {
            if(node == null){
                res.add("N")
                return
            }

            res.add(node.`val`.toString())
            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)
        return res.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val values = data.split(",")
        var i = 0

        fun dfs(): TreeNode? {
            if(values[i] == "N") {
                i++
                return null
            }

            val node = TreeNode(values[i].toInt())
            i++

            node.left = dfs()
            node.right = dfs()

            return node
        }

        return dfs()
    }
}
