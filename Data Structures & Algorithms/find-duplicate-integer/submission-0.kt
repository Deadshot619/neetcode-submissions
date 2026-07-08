class Solution {
    fun findDuplicate(nums: IntArray): Int {
        return negativeMarking(nums)
    }

    fun negativeMarking(nums: IntArray): Int {
        for(n in nums) {
            val i = abs(n)
            if(nums[i] < 0)
                return i
            nums[i] = nums[i] * -1
        }

        return -1
    }
}
