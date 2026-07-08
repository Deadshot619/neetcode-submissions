class Solution {
    fun findDuplicate(nums: IntArray): Int {
        // return negativeMarking(nums)
        return linkedList(nums)
    }

    fun negativeMarking(nums: IntArray): Int {
        for(n in nums) {
            val i = abs(n)
            if(nums[i] < 0)
                return i
            nums[i] = nums[i] * -1
        }

        return -1
    }

    fun linkedList(nums: IntArray): Int {
        var slow = 0
        var fast = 0

        while(true) {
            slow = nums[slow]
            fast = nums[nums[fast]]
            if(slow == fast)
                break
        }

        var slow2 = 0
        while(true) {
            if(slow2 == slow)
                return slow
            slow = nums[slow]
            slow2 = nums[slow2]
        }

        return -1
    }
}
