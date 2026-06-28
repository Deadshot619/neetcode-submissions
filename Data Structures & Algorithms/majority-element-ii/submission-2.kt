class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        // return bruteForce(nums)
        return boyerMooreVotingAlgo(nums)
    }

    fun bruteForce(nums: IntArray): List<Int> {
        val count = HashMap<Int, Int>()

        val res = mutableSetOf<Int>()
        val size = nums.size/3

        for(n in nums) {
            count[n] = (count[n] ?: 0) + 1
            if(count[n]!! > size)
                res.add(n)
        }

        return res.toList()
    }

    fun boyerMooreVotingAlgo(nums: IntArray): List<Int> {
        var countMap = HashMap<Int, Int>()

        for(n in nums) {
            countMap[n] = (countMap[n] ?: 0) + 1

            if(countMap.size < 3) continue

            val temp = countMap
            for((k, v) in countMap) {
                if(v > 1)
                    temp[k] = v - 1
            }
            countMap = temp
        }

        var res = mutableListOf<Int>()
        var c = 0
        for(k in countMap.keys) {
            c = 0
            for(n in nums) {
                if(n == k) c++
            }
            if(c > nums.size/3)
                res.add(k)
        }

        return res
    }
}
