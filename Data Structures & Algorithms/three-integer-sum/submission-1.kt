class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        var result = mutableListOf<List<Int>>()

        for(i in 0 until nums.size){
            val n = nums[i]

            if(n > 0) break
            if(i > 0 && n == nums[i - 1]) continue

            var l = i + 1
            var r = nums.size - 1

            while(l < r) {
                val total = n + nums[l] + nums[r]
                if(total > 0) r--
                else if(total < 0) l++
                else {
                    result.add(listOf(n, nums[l], nums[r]))
                    l++
                    r--

                    while(l < r && nums[l] == nums[l-1]) {
                        l++
                    }
                }
            }
        }

        return result
    }
}
