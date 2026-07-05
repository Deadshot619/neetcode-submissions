class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        return binarySearch(nums, target)
    }

    fun binarySearch(nums: IntArray, target: Int): Boolean {
        var l = 0
        var r = nums.size - 1

        while(l <= r) {
            val mid = l + (r - l)/2

            if(target == nums[mid]) return true

            if(nums[l] < nums[mid]) { // left sorted array
            if(nums[l] <= target && target < nums[mid]) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            } else if(nums[l] > nums[mid]) {
                if(nums[mid] < target && target <= nums[r]){
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            } else
                l++
        }
        
        return false
    }

}
