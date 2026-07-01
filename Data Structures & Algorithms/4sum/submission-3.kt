class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        return recursion(nums, target)
    }

    fun recursion(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val quad = mutableListOf<Int>()

        nums.sort()

        //k is the number of values we want to sum upto target
        //start is the index at which the 2sum will start
        //t is the updated target
        fun helper(k: Int, start: Int, t: Long) {
            if(k > 2) {
                // - k + 1 -> to have atleast k (4) elements to check the sum.
                for(i in start until nums.size - k + 1) {
                    if(i > start && nums[i] == nums[i - 1])
                        continue

                    quad.addLast(nums[i])
                    helper(k - 1, i + 1, t - nums[i])
                    quad.removeLast()
                }

                return
            }

            var l = start
            var r = nums.size - 1
            while(l < r) {
                val sum = nums[l].toLong() + nums[r]
                if(sum > t) {
                    r--
                } else if (sum < t) {
                    l++
                } else {
                    res.add(
                        quad.toMutableList().apply{ add(nums[l]); add(nums[r]) }
                    )
                    l++
                    while(l < r && nums[l] == nums[l - 1]) {
                        l++
                    }
                }
            }
        }

        helper(4, 0, target.toLong())
        return res
    }
}
