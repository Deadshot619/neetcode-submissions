class Solution {
    fun canPartition(nums: IntArray): Boolean {
        return bruteForce(nums)
    }

    fun bruteForce(nums: IntArray): Boolean {
        val sum = nums.sum()

        if(sum%2 != 0) return false

        var target = sum/2
        val cache = HashMap<Pair<Int, Int>, Boolean>()
        fun dfs(i: Int, sum: Int): Boolean {
            if(sum == target)
                return true
            
            if(i >= nums.size)
                return false

            val p = Pair(i, sum)
            if(p in cache) return cache[p]!!

            cache[p] = dfs(i + 1, nums[i] + sum) || dfs(i + 1, sum) 

            return cache[p]!!
        }

        return dfs(0, 0)
    }
}
