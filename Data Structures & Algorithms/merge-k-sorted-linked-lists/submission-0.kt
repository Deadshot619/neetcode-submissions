/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        return usingHeap(lists)
    }

    fun usingHeap(lists: Array<ListNode?>): ListNode? {
        if(lists.isNullOrEmpty()) return null

        val minHeap = PriorityQueue<ListNode> (compareBy { it.`val` })

        for(n in lists) {
            n?.let{
                minHeap.offer(it)
            }
        }

        val dummy = ListNode(-1)
        var cur = dummy

        while(minHeap.isNotEmpty()) {
            val node = minHeap.poll()
            cur.next = node
            cur = cur.next!!

            node.next?.let {
                minHeap.offer(it)
            }
        }

        return dummy.next!!
    }
}
