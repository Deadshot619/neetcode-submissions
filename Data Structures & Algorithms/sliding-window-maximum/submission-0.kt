class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val res = mutableListOf<Int>()

        val q = ArrayDeque<Int>() // Monotonous decreasing queue

        var l = 0
        for(r in nums.indices) {
            while(q.isNotEmpty() && nums[r] >= nums[q.last()]) {
                q.removeLast()
            }

            q.addLast(r)

            if(l > q.first()) {
                q.removeFirst()
            }

            if(r + 1 >= k) {
                res.add(nums[q.first()])
                l++
            }
        }

        return res.toIntArray()
    }
}
