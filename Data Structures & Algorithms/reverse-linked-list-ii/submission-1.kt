/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        // return selfCode(head, left, right)
        return neetCode(head, left, right)
    }

    fun neetCode(head: ListNode?, left: Int, right: Int): ListNode? {
        if(left == right) return head

        val dummy = ListNode(-1)
        dummy.next = head

        var leftPrev: ListNode? = dummy
        var cur: ListNode? = head
        repeat(left - 1) {
            leftPrev = leftPrev?.next
            cur = cur?.next
        }

        //reverse
        var prev: ListNode? = null
        repeat(right - left + 1) {
            var temp: ListNode? = cur?.next
            cur?.next = prev
            prev = cur
            cur = temp
        }

        //join nodes
        leftPrev?.next?.next = cur
        leftPrev?.next = prev

        return dummy?.next
    }

    fun selfCode(head: ListNode?, left: Int, right: Int): ListNode? {
        if(left == right) return head

        val dummy = ListNode(-1)
        dummy.next = head

        val leftN = findNthNode(dummy, left)    // find Left - 1 node
        val rightN = findNthNode(dummy, right)  // find right - 1 node
        val tempR = rightN?.next?.next  // Saving this node to be used again

        // Reversed Left Node & Reversed right node
        val (rLeftNode, rRightNode) = reverseNode(leftN?.next, rightN?.next)
        leftN?.next = rLeftNode
        rRightNode?.next = tempR

        return dummy?.next
    }

    fun findNthNode(head: ListNode?, i: Int): ListNode? { // Find i - 1 node
        var n = 1
        var cur: ListNode? = head
        while(n < i) {
            cur = cur?.next
            n++
        }
        return cur
    }

    fun reverseNode(left: ListNode?, right: ListNode?): Pair<ListNode?, ListNode?> {
        var prev: ListNode? = left
        var cur = left?.next

        while(prev != right) {
            var temp = cur?.next
            cur?.next = prev
            prev = cur
            cur = temp
        }

        return Pair(right, left)
    }
}
