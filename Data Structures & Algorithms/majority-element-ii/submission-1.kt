class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        return bruteForce(nums)
    }

    fun bruteForce(nums: IntArray): List<Int> {
        val count = HashMap<Int, Int>()

        val res = mutableSetOf<Int>()
        val size = nums.size/3

        for(n in nums) {
            count[n] = (count[n] ?: 0) + 1
            if(count[n]!! > size)
                res.add(n)
        }

        return res.toList()
    }
}
