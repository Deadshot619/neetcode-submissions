class LRUCache(val capacity: Int) {
    val cache = HashMap<Int, Node>()
    val lru = Node(-1, -1)
    val mru = Node(-1, -1)

    init {
        lru.next = mru
        mru.prev = lru
    }

    fun get(key: Int): Int {
        return cache[key]?.let { node ->
            remove(node)
            insert(node)
            node.value
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        cache[key]?.let { node ->
            remove(node)
            cache.remove(key)
        }

        val node = Node(key, value)
        cache[key] = node
        insert(node)

        if(cache.size > capacity){
            lru.next?.let { node ->
                remove(node)
                cache.remove(node.key)
            }
        }
    }

    private fun insert(node: Node) {
        val prev = mru.prev
        node?.prev = prev
        node?.next = mru
        prev?.next = node
        mru?.prev = node
    }

    private fun remove(node: Node) {
        val prev = node.prev
        val next = node.next
        prev?.next = next
        next?.prev = prev
    }
}

data class Node(
    val key: Int,
    val value: Int,
    var prev: Node? = null,
    var next: Node? = null
)
