class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        // return backtracking(nums, k)
        return backtrackingOptimal(nums, k)
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

    fun backtrackingOptimal(nums: IntArray, kEqual: Int): Boolean {
        val sum = nums.sum()
        val target = sum/kEqual

        if(sum % kEqual != 0) return false

        val used = BooleanArray(nums.size)

        fun dfs(i: Int, k: Int, subsetSum: Int): Boolean {
            if(k == 0) return true
            if(subsetSum == target) // found a subset
                return dfs(0, k - 1, 0)

            for(j in i until nums.size) {
                if(used[j] || subsetSum + nums[j] > target)
                    continue

                used[j] = true

                if(dfs(j + 1, k, subsetSum + nums[j]))
                    return true

                used[j] = false
            }

            return false
        }

        return dfs(0, kEqual, 0)
    }


}
