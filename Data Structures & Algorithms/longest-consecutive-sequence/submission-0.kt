class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        return usingSet(nums)
    }

    fun usingSet(nums: IntArray): Int {
        val numSet = nums.toSet()
        var longestSequence = 0

        for(n in nums) {
            if(n - 1 in numSet)
                continue
            
            var curSize = 1
            var num = n
            while(num + 1 in numSet) {
                curSize++
                num++
            }

            if(curSize > longestSequence)
                longestSequence = curSize
        }

        return longestSequence
    }
}
