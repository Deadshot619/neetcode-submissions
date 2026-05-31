class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        return backtracking(nums)
    }

    fun backtracking(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()

        val cur = mutableListOf<Int>()

        fun dfs(i: Int) {
            if(i >= nums.size) {
                res.add(cur.toList())
                return
            }

            cur.add(nums[i])
            dfs(i + 1)

            cur.removeLast()
            var next = i + 1

            while(next < nums.size && nums[i] == nums[next]){
                next++
            }
            dfs(next)
        }

        dfs(0)
        return res
    }
}
