class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        return bucketSort(nums, k)
    }

    fun bucketSort(nums: IntArray, k: Int): IntArray {
        val freqMap = mutableMapOf<Int, Int>()

        for(n in nums) {
            freqMap[n] = (freqMap[n] ?: 0) + 1
        }

        val bucketMap = mutableMapOf<Int, MutableList<Int>>()

        for(n in freqMap.keys) { //freq to list of numbers
            val freq = freqMap[n] ?: -1
            bucketMap.getOrPut(freq) {
                mutableListOf<Int>()
            }.add(n)
        }

        val result = mutableListOf<Int>()
        for(i in nums.size downTo 1) {
            for(n in bucketMap[i] ?: mutableListOf()) {
                if(result.size == k)
                    return result.toIntArray()
                result.add(n)
            }
        }
        return result.toIntArray()
    }
}
