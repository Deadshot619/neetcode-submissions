/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        return twoPointer(head)
    }

    fun twoPointer(head: ListNode?): ListNode? {    // T: O(n), S: O(1)
        var prev: ListNode? = null
        var cur = head

        while(cur != null) {
            val temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        }

        return prev
    }
}
