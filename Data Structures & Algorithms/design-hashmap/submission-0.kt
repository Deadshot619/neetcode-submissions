class MyHashMap() {
    val hashMap = Array(10000){ ListNode() }

    fun put(key: Int, value: Int) {
        val index = key % 10000
        var cur: ListNode? = hashMap[index]
        while(cur?.next != null) {
            if(cur.next?.key == key) {
                cur.next?.value = value
                return
            }
            cur = cur.next
        }
        cur?.next = ListNode(key, value)
    }

    fun get(key: Int): Int {
        val index = key % 10000
        var cur: ListNode? = hashMap[index]
        while(cur?.next != null) {
            if(cur.next?.key == key) {
                return cur.next?.value ?: -1
            }
            cur = cur.next
        }
        return -1
    }

    fun remove(key: Int) {
        val index = key % 10000
        var cur: ListNode? = hashMap[index]
        while(cur?.next != null) {
            if(cur.next?.key == key) {
                cur.next = cur.next?.next
                return
            }
            cur = cur.next
        }
    }
}

class ListNode(
    val key: Int = -1,
    var value: Int = -1,
    var next: ListNode? = null
)

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
