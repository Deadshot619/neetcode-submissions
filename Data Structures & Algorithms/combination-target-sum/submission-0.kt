class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        return backtracking(nums, target)
    }

    fun backtracking(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        val cur = mutableListOf<Int>()

        fun dfs(i: Int, total: Int) {
            if(target == total) {
                res.add(cur.toList())
                return
            }

            if(i >= nums.size || total > target)
                return

            cur.add(nums[i])
            dfs(i, total + nums[i])

            cur.removeLast()
            dfs(i + 1, total)
        }

        dfs(0, 0)
        return res
    }
}
