class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        return backtracking(candidates, target)
    }

    fun backtracking(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()

        var cur = mutableListOf<Int>()

        fun dfs(i: Int, total: Int) {
            if(total == target) {
                res.add(cur.toList())
                return
            }

            if(i >= nums.size || total > target)
                return

            cur.add(nums[i])
            dfs(i + 1, total + nums[i])

            cur.removeLast()
            var c = i + 1
            while(c < nums.size && nums[i] == nums[c]){
                c++
            }
            dfs(c, total)
        }

        dfs(0, 0)
        return res
    }
}
