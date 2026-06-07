class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        return usingHeap(tasks, n)
    }

    fun usingHeap(tasks: CharArray, n: Int): Int {
        val counter = mutableMapOf<Char, Int>()

        tasks.forEach {
            counter[it] = (counter[it] ?: 0) + 1
        }

        val maxHeap = PriorityQueue<Int>(compareByDescending {it} ).apply {
            addAll(counter.values)
        }

        val queue = ArrayDeque<Pair<Int, Int>>() // count to Time

        var time = 0

        while(maxHeap.isNotEmpty() || queue.isNotEmpty()) {
            time++

            if(maxHeap.isNotEmpty()){
                val itemLeft = maxHeap.poll()

                if(itemLeft > 1) {
                    queue.addLast(Pair(itemLeft - 1, time + n))
                }
            }

            if(queue.isNotEmpty() && queue.first().second == time) {
                maxHeap.add(queue.removeFirst().first)
            }
        }

        return time
    }
}
