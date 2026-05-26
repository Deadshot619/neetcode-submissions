/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val oldToNew = HashMap<Node?, Node?>()
        oldToNew[null] = null

        var cur = head
        while(cur != null) {
            val node = Node(cur?.`val` ?: 0)
            oldToNew[cur] = node
            cur = cur?.next
        }

        cur = head
        while(cur != null) {
            val node = oldToNew[cur]
            node?.next = oldToNew[cur?.next]
            node?.random = oldToNew[cur?.random]
            cur = cur?.next
        }

        return oldToNew[head]
    }
}
