/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if(left == right) return head

        val dummy = ListNode(-1)
        dummy.next = head

        val leftN = findNthNode(dummy, left)
        val rightN = findNthNode(dummy, right)
        val tempR = rightN?.next?.next

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
