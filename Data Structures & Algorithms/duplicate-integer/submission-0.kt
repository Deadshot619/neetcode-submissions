class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        return usingSet(nums)
    }

    fun usingSet(nums: IntArray): Boolean {
        val uniqueSet = mutableSetOf<Int>()

        for(n in nums)
            if(uniqueSet.add(n) == false)
                return true
        return false
    }
}
