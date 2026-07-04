class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target)
    }

    fun binarySearch(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        var mid = 0
        while(l <= r) {
            mid = l + (r - l)/2

            if(target > nums[mid]) {
                l = mid + 1
            } else if(target < nums[mid]) {
                r = mid - 1
            } else {
                return mid
            }
        }
        
        val res = if(target > nums[mid]) mid + 1 
            else mid

        return res
    }
}
