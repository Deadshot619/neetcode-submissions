class MedianFinder {
    val minHeap = PriorityQueue<Int>()  // Right Heap
    val maxHeap = PriorityQueue<Int>(compareByDescending {it}) // Left Heap

    fun addNum(num: Int) {
        if(num > minHeap.peek() ?: 0) {
            minHeap.offer(num)
        } else {
            maxHeap.offer(num)
        }

        while(maxHeap.size > minHeap.size + 1) {
            val n = maxHeap.poll()
            minHeap.offer(n)
        }

        while(minHeap.size > maxHeap.size + 1) {
            val n = minHeap.poll()
            maxHeap.offer(n)
        }
    }

    fun findMedian(): Double {
        if(minHeap.size == maxHeap.size) {
            return (minHeap.peek() + maxHeap.peek())/2.0
        }

        if(minHeap.size > maxHeap.size)
            return minHeap.peek().toDouble()
        
        return maxHeap.peek().toDouble()
    }
}
