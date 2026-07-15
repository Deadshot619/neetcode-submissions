class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        return backtracking(nums, k)
    }

    fun backtracking(nums: IntArray, k: Int): Boolean {
        val sum = nums.sum()
        val totalMax = nums.max()
        val subsetMax = sum/k

        if(totalMax > subsetMax) return false

        val subsets = IntArray(k)
        nums.sortDescending()

        fun dfs(i: Int): Boolean {
            if(i >= nums.size) return true

            for(j in 0 until k) {
                if(subsets[j] + nums[i] <= subsetMax){
                    subsets[j] = subsets[j] + nums[i]
                    if(dfs(i + 1))
                        return true
                    subsets[j] = subsets[j] - nums[i]
                }
            }

            return false
        }

        return dfs(0)
    }
}
