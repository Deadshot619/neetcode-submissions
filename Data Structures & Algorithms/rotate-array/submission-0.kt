class Solution {
    fun rotate(nums: IntArray, k: Int) {
        return optimal(nums, k)
    }

    fun optimal(nums: IntArray, k: Int) {
        val rotations = k % nums.size

        fun rotateArray(start: Int, end: Int) {
            var l = start
            var r = end

            while(l < r) {
                val temp = nums[l]
                nums[l] = nums[r]
                nums[r] = temp

                l++
                r--
            }
        }

        // Rotate the whole array [1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1]
        rotateArray(0, nums.size - 1)

        // Rotate first k elements [5, 4, 3, 2, 1] -> [4, 5, 3, 2, 1]
        rotateArray(0, rotations - 1)

        // Rotate remaining elements [5, 4, 3, 2, 1] -> [4, 5, 1, 2, 3]
        rotateArray(rotations, nums.size - 1)
    }
}
