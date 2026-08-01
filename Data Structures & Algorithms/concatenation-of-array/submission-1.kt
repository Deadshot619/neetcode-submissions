class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        // return singlePass(nums)
        return simpleKotlinWay(nums)
    }

    fun singlePass(nums: IntArray): IntArray {        
        val n = nums.size
        val res = IntArray(n + n)
        for(i in 0 until n) {
            res[i] = nums[i]
            res[i + n] = nums[i]
        }

        return res
    }

    fun simpleKotlinWay(nums: IntArray): IntArray {        
        return nums + nums
    }
}
