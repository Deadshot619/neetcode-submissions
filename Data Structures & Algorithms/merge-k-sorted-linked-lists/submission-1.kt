/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        // return usingHeap(lists)
        return usingMergeSort(lists)
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

    fun usingMergeSort(lists: Array<ListNode?>): ListNode? {
        if(lists.isNullOrEmpty()) return null

        var alists = lists
        while(alists.size > 1) {
            var mergedLists = mutableListOf<ListNode?>()

            for(i in 0 until alists.size step 2) {
                mergedLists.add(mergeSortedLinkedLists(
                    list1 = alists[i],
                    list2 = if(i + 1 < alists.size) alists[i + 1] else null
                ))
            }

            alists = mergedLists.toTypedArray()
        }

        return alists.getOrNull(0)
    }

    private fun mergeSortedLinkedLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        val dummy = ListNode(-1)
        var cur = dummy

        while(l1 != null && l2 != null) {
            if(l1.`val` < l2.`val`) {
                cur.next = l1
                l1 = l1.next
            } else {
                cur.next = l2
                l2 = l2.next
            }
            cur = cur.next!!
        }

        if(l1 != null) cur.next = l1
        if(l2 != null) cur.next = l2

        return dummy.next
    }
}
