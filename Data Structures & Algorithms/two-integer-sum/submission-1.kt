class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val resMap = mutableMapOf<Int, Int>()   // value to index

        nums.forEachIndexed { i, n ->
            if(resMap[target - n] != null)
                return intArrayOf(resMap[target - n] ?: 0, i)
            
            resMap[n] = i
        }
        return intArrayOf(-1, -1)
    }
}
