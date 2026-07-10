class MyCircularQueue(val k: Int) {
    val start = ListNode(-1)
    val end = ListNode(-1)

    init{
        start?.next = end
        start?.prev = end
        end?.next = start
        end?.prev = start
    }

    var size = 0

    fun enQueue(value: Int): Boolean {
        if(size == k) return false
        size++

        val last = end?.prev
        val node = ListNode(value)
        node?.next = end
        node?.prev = last
        last?.next = node
        end?.prev = node

        return true
    }

    fun deQueue(): Boolean {
        if(size == 0) return false
        size--

        val second = start?.next?.next
        second?.prev = second?.prev?.prev
        start?.next = second

        return true
    }

    fun Front(): Int {
        return start?.next?.num ?: -1
    }

    fun Rear(): Int {
        return end?.prev?.num ?: -1
    }

    fun isEmpty(): Boolean {
        return (start?.next?.num ?: -1) < 0
    }

    fun isFull(): Boolean {
        return size == k
    }
}

data class ListNode(
    val num: Int,
    var next: ListNode? = null,
    var prev: ListNode? = null,
)

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
