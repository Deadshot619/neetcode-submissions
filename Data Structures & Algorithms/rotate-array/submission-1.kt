class Solution {
    fun rotate(nums: IntArray, k: Int) {
        sliceAndRotate(nums, k)
    }

    fun sliceAndRotate(nums: IntArray, k: Int) {
        fun helper(i: Int, j: Int) {
            var l = i
            var r = j

            while(l < r) {
                val temp = nums[l]
                nums[l] = nums[r]
                nums[r] = temp
                l++
                r--
            }
        }

        val newK = k % nums.size
        if(newK == 0) return

        // Rotate whole array
        helper(0, nums.size - 1)

        //Rotate first part
        helper(0, newK - 1)

        //Rotate second part
        helper(newK, nums.size - 1)
    }
}
