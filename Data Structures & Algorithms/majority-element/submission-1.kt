class Solution {
    fun majorityElement(nums: IntArray): Int {
        // return usingMap(nums)
        return boyreMooreAlgo(nums)
    }

    fun usingMap(nums: IntArray): Int {
        val count = HashMap<Int, Int>()
        var res = nums[0]
        var maxCount = 0

        for(n in nums) {
            count[n] = (count[n] ?: 0) + 1
            if(count[n]!! > maxCount) {
                res = n
                maxCount = count[n]!!
            }
        }

        return res
    }

    fun boyreMooreAlgo(nums: IntArray): Int {
        var res = 0
        var count = 0

        for(n in nums) {
            if(count == 0)res = n
            if(n == res)
                count++
            else
                count--
        }

        return res
    }
}
