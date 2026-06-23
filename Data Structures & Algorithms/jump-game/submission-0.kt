class Solution {
    fun canJump(nums: IntArray): Boolean {
        return backtracking(nums)
    }

    fun backtracking(nums: IntArray): Boolean {

        fun dfs(i: Int): Boolean {
            if(i >= nums.size - 1)return true

            if(nums[i] == 0) return false

            var res = false

            for(j in 1..nums[i]) {
                res = res || dfs(i + j)
            }

            return res
        }

        return dfs(0)
    }
}
