class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return usingHeap(nums, k)
    }

    fun usingHeap(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()

        nums.forEach {
            minHeap.offer(it)
            if(minHeap.size > k)
                minHeap.poll()
        }

        return minHeap.peek()
    }
}
