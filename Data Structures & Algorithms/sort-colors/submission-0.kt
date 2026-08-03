class Solution {
    fun sortColors(nums: IntArray) {
        onePass(nums)
    }

    fun onePass(nums: IntArray) {
        var (l, r, i) = listOf(0, nums.size - 1, 0)

        fun swap(a: Int, b: Int) {
            val temp = nums[a]
            nums[a] = nums[b]
            nums[b] = temp
        }

        while(i <= r) {
            if(nums[i] == 0) {
                swap(l, i)
                l++
            } else if (nums[i] == 2) {
                swap(i, r)
                r--
                i--
            }
            i++
        }
    }
}
