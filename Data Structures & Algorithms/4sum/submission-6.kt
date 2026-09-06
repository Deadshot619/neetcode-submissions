class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        return kSum(nums, target)
    }

    fun kSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val quad = mutableListOf<Int>()
        nums.sort()

        fun helper(k: Int, s: Int, t: Long) {
            if(k > 2) {
                for(i in s..nums.size - k) {
                    if(i > s && nums[i] == nums[i - 1]) continue
                    quad.add(nums[i])
                    helper(k - 1, i + 1, t + nums[i])
                    quad.removeLast()
                }
                return
            }

            var l = s
            var r = nums.size - 1
            val newTarget = target - t

            while(l < r) {
                val sum = nums[l] + nums[r]
                if(sum > newTarget) r--
                else if(sum < newTarget) l++
                else {
                    res.add(quad + listOf(nums[l], nums[r]))
                    l++
                    while(l < r && nums[l] == nums[l - 1])
                        l++
                }
            }
        }

        helper(4, 0, 0.toLong())
        return res
    }
}
