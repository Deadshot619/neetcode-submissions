class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        return backtracking(nums)
    }

    fun backtracking(nums: IntArray): List<List<Int>> {
        if(nums.isEmpty()) return listOf(listOf())

        val perms = backtracking(nums.sliceArray(1 until nums.size))
        val res = mutableListOf<List<Int>>()

        for(p in perms) {
            for(i in 0 until p.size + 1){
                val pCopy = p.toMutableList()
                pCopy.add(i, nums[0])
                res.add(pCopy)
            }
        }

        return res
    }
}
