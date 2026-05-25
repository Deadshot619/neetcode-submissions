/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var p1 = list1
        var p2 = list2
        var dummy = ListNode(0)
        var p3: ListNode? = dummy

        while(p1 != null && p2 != null) {
            if(p1.`val` < p2.`val`) {
                p3?.next = p1
                p1 = p1.next
            } else {
                p3?.next = p2
                p2 = p2.next
            }
            p3 = p3?.next
        }

        if(p1 != null) {
            p3?.next = p1
        }

        if(p2 != null) {
            p3?.next = p2
        }

        return dummy?.next
    }
}
