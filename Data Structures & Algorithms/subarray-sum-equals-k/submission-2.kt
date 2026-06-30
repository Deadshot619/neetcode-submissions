class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        // return bruteForce(nums, k)
        return usingPrefixSum(nums, k)
    }

    fun bruteForce(nums: IntArray, k: Int): Int {
        var count = 0

        for(i in 0 until nums.size) {
            var sum = 0
            for(j in i until nums.size) {
                sum += nums[j]
                if(sum == k) count++
            }
        }

        return count
    }

    fun usingPrefixSum(nums: IntArray, k: Int): Int {
        var count = 0
        var curSum = 0
        val prefixCount = HashMap<Int, Int>() //prefixsum to count
        prefixCount[0] = 1

        for(n in nums) {
            curSum += n
            val diff = curSum - k

            count += (prefixCount[diff] ?: 0)
            prefixCount[curSum] = 1 + (prefixCount[curSum] ?: 0)
        }

        return count
    }
}
