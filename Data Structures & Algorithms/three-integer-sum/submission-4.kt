class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        return bySorting(nums)
    }

    fun bySorting(nums: IntArray): List<List<Int>> {
        nums.sort()

        val res = mutableListOf<List<Int>>()

        for(i in 0 until nums.size) {
            val n1 = nums[i]
            if(n1 > 0) break
            if(i > 0 && n1 == nums[i - 1]) continue

            var l = i + 1
            var r = nums.size - 1

            while(l < r) {
                val total = n1 + nums[l] + nums[r]
                if(total > 0) r--
                else if(total < 0) l++
                else {
                    res.add(listOf(n1, nums[l], nums[r]))
                    l++

                    while(l < r && nums[l] == nums[l - 1])
                        l++
                }
            } 
        }

        return res
    }
}
