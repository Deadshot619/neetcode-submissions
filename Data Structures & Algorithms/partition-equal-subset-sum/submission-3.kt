class Solution {
    fun canPartition(nums: IntArray): Boolean {
        return bruteForce(nums)
        return bottomUp(nums)
    }

    fun bruteForce(nums: IntArray): Boolean {
        val sum = nums.sum()

        if(sum%2 != 0) return false

        var target = sum/2
        val cache = HashMap<Pair<Int, Int>, Boolean>()
        fun dfs(i: Int, sum: Int): Boolean {
            if(sum == target)
                return true
            
            if(sum > target || i >= nums.size)
                return false

            val p = Pair(i, sum)
            if(p in cache) return cache[p]!!

            cache[p] = dfs(i + 1, nums[i] + sum) || dfs(i + 1, sum) 

            return cache[p]!!
        }

        return dfs(0, 0)
    }

    fun bottomUp(nums: IntArray): Boolean {
        val sum = nums.sum()

        if(sum%2 != 0) return false
        
        var target = sum/2
        val dp = mutableSetOf<Int>()
        dp.add(0)

        for(n in nums) {
            val tempDp = dp.toMutableSet()
            tempDp.add(n)
            for(t in tempDp) {
                if(t == target) return true
                tempDp.add(n * t)
            }
            dp.addAll(tempDp)
        }

        return if(target in dp) true else false
    }
}
