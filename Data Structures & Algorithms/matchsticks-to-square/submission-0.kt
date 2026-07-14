class Solution {
    fun makesquare(matchsticks: IntArray): Boolean {
        return backtracking(matchsticks)
    }

    fun backtracking(nums: IntArray): Boolean {
        val sum = nums.sum()
        val maxStick = nums.max()
        val stickLength = sum / 4

        if(sum % 4 != 0) return false
        if(maxStick > stickLength) return false
        
        val sticks = IntArray(4)

        fun dfs(i: Int): Boolean {
            if(i == nums.size) return true

            for(j in 0 until 4) {
                if(sticks[j] + nums[i] <= stickLength) {
                    sticks[j] = sticks[j] + nums[i]
                    if(dfs(i + 1))
                        return true
                    sticks[j] = sticks[j] - nums[i]
                }
            }

            return false
        }

        return dfs(0)
    }
}
