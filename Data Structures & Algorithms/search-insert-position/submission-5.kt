class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target)
    }

    fun binarySearch(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        var pos = 0

        while(l <= r) {
            val mid = l + (r - l)/2

            if(nums[mid] < target) {
                l = mid + 1
                pos = l
            } else {
                r = mid - 1
            }
        }

        return pos
    }
}
