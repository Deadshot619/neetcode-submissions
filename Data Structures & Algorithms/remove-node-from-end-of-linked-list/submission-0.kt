/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var dummy = ListNode(0)
        dummy.next = head

        var c = 0
        var r: ListNode? = dummy
        var l: ListNode? = dummy
        while(r?.next != null) {
            if(c >= n) {
                l = l?.next
            }
            r = r?.next
            c++
        }
        l?.next = l?.next?.next

        return dummy.next
    }
}
