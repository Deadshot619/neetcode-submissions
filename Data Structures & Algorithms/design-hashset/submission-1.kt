class MyHashSet() {
    val hashSet = HashMap<Int, ListNode>()

    fun add(key: Int) {
        val index = key % 10000
        var cur = hashSet.getOrPut(index) { ListNode() }

        while(cur!!.next != null) {
            if(cur.next!!.key == key)
                return
            cur = cur.next!!
        }
        cur.next = ListNode(key)
    }

    fun remove(key: Int) {
        val index = key % 10000
        var cur: ListNode? = hashSet.getOrPut(index) { ListNode() }

        while(cur?.next != null) {
            if(cur.next?.key == key)
                cur.next = cur.next?.next
            cur = cur.next
        }
    }

    fun contains(key: Int): Boolean {
        val index = key % 10000
        var cur = hashSet.getOrPut(index) { ListNode() }

        while(cur!!.next != null) {
            if(cur.next!!.key == key)
                return true
            cur = cur.next!!
        }

        return false
    }
}

data class ListNode(
    val key: Int = -1,
    var next: ListNode? = null
)

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
