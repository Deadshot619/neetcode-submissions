class KthLargest(val k: Int, nums: IntArray) {

    val heap = PriorityQueue<Int>()

    init {
        nums.forEach {
            heap.offer(it)
        }
        while(heap.size > k) {
            heap.poll()
        }
    }

    fun add(`val`: Int): Int {
        heap.offer(`val`)
        while(heap.size > k) {
            heap.poll()
        }
        return heap.peek()
    }
}
