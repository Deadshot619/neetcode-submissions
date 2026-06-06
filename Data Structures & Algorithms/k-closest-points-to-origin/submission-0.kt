class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue<IntArray>(compareByDescending {
            it[0] * it[0] + it[1] * it[1]
        })

        for(p in points) {
            heap.offer(p)
        }

        while (heap.size > k) {
            heap.poll()
        }

        return heap.toTypedArray()
    }
}
