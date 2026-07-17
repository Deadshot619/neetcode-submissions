class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        return iterative(nums)
    }

    fun backtracking(nums: IntArray): List<List<Int>> {
        if(nums.isEmpty()) return listOf(listOf())


        val res = mutableListOf<List<Int>>()
        return res
    }

    fun iterative(nums: IntArray): List<List<Int>> {
        var perms = mutableSetOf<List<Int>>()
        perms.add(listOf())

        for(n in nums) {
            val newPerms = mutableSetOf<List<Int>>()
            for(p in perms) {
                for(i in 0..p.size) {
                    val pCopy = p.toMutableList()
                    pCopy.add(i, n)
                    newPerms.add(pCopy)
                }
            }
            perms = newPerms
        }

        return perms.toList()
    }
}
