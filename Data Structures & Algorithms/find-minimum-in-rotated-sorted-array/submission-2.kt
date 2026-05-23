class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        var min = Integer.MAX_VALUE

        while(l <= r) {
            if(nums[l] <= nums[r]){
                min = minOf(min, nums[l])
                break
            }

            val mid = (r + l)/2
            min = minOf(min, nums[mid])
            
            if(nums[mid] >= nums[l]) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return min
    }
}
