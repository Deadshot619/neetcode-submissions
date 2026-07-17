class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        // return backtracking(nums)
        return iterative(nums)
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

    fun iterative(nums: IntArray): List<List<Int>> {
        var perms = mutableListOf<List<Int>>()
        perms.add(listOf())

        for(n in nums) {
            val newPerms = mutableListOf<List<Int>>()
            for(p in perms) {
                for(i in 0..p.size) {
                    val pCopy = p.toMutableList()
                    pCopy.add(i, n)
                    newPerms.add(pCopy)
                }
            }
            perms = newPerms
        }

        return perms
    }
}
