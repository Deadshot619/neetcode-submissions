class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        for(i in 0 until nums.size) {
            if(nums[i] < 0)
                nums[i] = 0
        }

        for(i in 0 until nums.size) {
            // Number could have been made negative by another number
            val abs = Math.abs(nums[i]) - 1
            if(abs < 0 || abs >= nums.size) continue
            if(nums[abs] <= 0) {
                nums[abs] = Integer.MAX_VALUE
            } else {
                nums[abs] = nums[abs] * -1
            }
        }

        var res = 1
        for(n in nums) {
            if(n >= 0 && n != Integer.MAX_VALUE)
                return res
            res++
        }

        return res
    }
}
