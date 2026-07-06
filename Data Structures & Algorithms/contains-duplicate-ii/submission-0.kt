class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        return slidingWindow(nums, k)
    }

    fun slidingWindow(nums: IntArray, k: Int): Boolean {
        val numSet = HashSet<Int>()
        var l = 0

        for(r in 0 until nums.size) {
            if(r > k){
                numSet.remove(nums[l])
                l++
            }
            if(nums[r] in numSet)
                return true
            numSet.add(nums[r])
        }

        return false
    }
}
