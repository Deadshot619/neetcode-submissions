class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numStore = mutableMapOf<Int, Int>()   // value to index

        nums.forEachIndexed { i, n ->
            if(numStore[target - n] != null)
                return intArrayOf(numStore[target - n] ?: 0, i)
            
            numStore[n] = i
        }
        return intArrayOf(-1, -1)
    }
}
