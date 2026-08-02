class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        return twoPass(nums, `val`)
    }

    fun twoPass(nums: IntArray, `val`: Int): Int {
        var c = 0
        for(i in nums.indices) {
            if(nums[i] == `val`) {
                nums[i] = -1
                c++
            }
        }

        var l = 0
        var r = nums.size - 1
        while(l < r) {
            while(l < r && nums[r] == -1){
                r--
            }
            while(l < r && nums[l] != -1){
                l++
            }
            if(l < r && nums[l] == -1) {
                var temp = nums[r]
                nums[r] = nums[l]
                nums[l] = temp
                l++
                r--
            }
        }

        return nums.size - c
    }
}
