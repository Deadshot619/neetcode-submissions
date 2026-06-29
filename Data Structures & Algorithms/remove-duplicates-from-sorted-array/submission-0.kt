class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var l = 1

        for(r in 1 until nums.size) {
            if(nums[r] != nums[r-1]) {
                nums[l] = nums[r]
                l++
            }
        }

        return l
    }
}
