/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var a = l1
        var b = l2
        
        val dummy = ListNode(0)
        var cur: ListNode? = dummy
        var carry = 0
        while(a != null || b != null || carry > 0) {
            val num1 = a?.`val` ?: 0
            val num2 = b?.`val` ?: 0
            val total = num1 + num2 + carry

            carry = total / 10
            cur?.next = ListNode(total % 10)

            a = a?.next
            b = b?.next
            cur = cur?.next
        }

        return dummy?.next
    }
}
