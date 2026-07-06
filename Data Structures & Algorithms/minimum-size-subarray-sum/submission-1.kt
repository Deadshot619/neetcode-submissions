class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        return slidingWindow(target, nums)
    }

    fun slidingWindow(target: Int, nums: IntArray): Int {
        var minSize = Integer.MAX_VALUE
        var total = 0 
        
        var l = 0

        for(r in 0 until nums.size) {
            total = total + nums[r]
            while(total >= target) {
                minSize = min(minSize, r - l + 1)
                total = total - nums[l]
                l++
            }
        }

        return if(minSize == Integer.MAX_VALUE) 0 else minSize
    }
}
