/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        return recursiveDFS(node)
    }

    fun recursiveDFS(root: Node?): Node? {
        if(root == null) return null

        val oldToNew = HashMap<Node?, Node?>()

        fun dfs(node: Node?): Node? {
            if(node in oldToNew) return oldToNew[node]

            val copy = Node(node!!.`val`)
            oldToNew[node] = copy

            for(n in node.neighbors) {
                copy.neighbors.add(dfs(n))
            }

            return copy
        }

        return dfs(root)!!
    }
}
