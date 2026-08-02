class Solution {
    fun majorityElement(nums: IntArray): Int {
        return usingMap(nums)
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
}
