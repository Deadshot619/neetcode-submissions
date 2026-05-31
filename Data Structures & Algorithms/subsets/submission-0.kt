class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        return backtracking(nums)
    }

    fun backtracking(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        val cur = mutableListOf<Int>()
        
        fun dfs(i: Int) {
            if(i >= nums.size) {
                res.add(cur.toList())
                return
            }

            // Include the ith value
            cur.add(nums[i])
            dfs(i + 1)

            cur.removeLast()
            dfs(i + 1)
        }
        
        dfs(0)
        return res
    }
}
