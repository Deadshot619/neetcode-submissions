/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        // find middle
        var slow = head
        var fast = head?.next
        while(fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        // Reverse the list
        var second = slow?.next
        slow?.next = null
        var l1 = head
        var l2 = reverse(second)

        // Merge the list
        while(l2 != null) {
            var temp1 = l1?.next
            var temp2 = l2?.next
            l1?.next = l2
            l2?.next = temp1
            l1 = temp1
            l2 = temp2
        }
    }

    fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur = head

        while(cur != null) {
            var temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        }

        return prev
    }
}
