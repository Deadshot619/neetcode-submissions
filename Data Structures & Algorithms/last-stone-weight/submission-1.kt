class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int>(compareByDescending {it})

        stones.forEach {
            heap.offer(it)
        }

        while(heap.size > 1) {
            val v1 = heap.poll()
            val v2 = heap.poll()
            heap.offer(v1-v2)
        }

        return heap.peek()
    }
}
