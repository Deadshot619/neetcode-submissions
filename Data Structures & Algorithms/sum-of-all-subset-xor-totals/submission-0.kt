class Solution {
    fun subsetXORSum(nums: IntArray): Int {
        return backtracking(nums)
    }

    fun backtracking(nums: IntArray): Int {
        var sum = 0
        var curSubset = mutableListOf<Int>()

        fun dfs(i: Int) {
            if(i >= nums.size) {
                var temp = 0
                curSubset.forEach {
                    temp = temp xor it
                }
                sum += temp
                return
            }

            curSubset.add(nums[i])
            dfs(i + 1)

            curSubset.removeLast()
            dfs(i + 1)
        }
        
        dfs(0)
        return sum
    }
}
