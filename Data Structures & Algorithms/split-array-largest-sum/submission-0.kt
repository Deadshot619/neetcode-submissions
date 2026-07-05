class Solution {
    fun splitArray(nums: IntArray, k: Int): Int {
        return binarySearch(nums, k)
    }

    fun binarySearch(nums: IntArray, k: Int): Int {
        var l = nums.max()
        var r = nums.sum()
        var res = r

        fun canSplit(mid: Int): Boolean {
            var curSum = 0
            var subArrays = 0

            for(n in nums) {
                curSum += n
                if(curSum > mid) {
                    curSum = n
                    subArrays++
                }
            }

            return subArrays + 1 <= k
        }

        while(l <= r) {
            val mid = l + (r - l)/2

            if(canSplit(mid)) {
                r = mid - 1
                res = minOf(res, mid)
            } else {
                l = mid + 1
            }
        }

        return res
    }

}
