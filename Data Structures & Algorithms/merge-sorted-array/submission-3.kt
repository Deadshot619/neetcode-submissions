class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        threePointer(nums1, m, nums2, n)
    }

    fun threePointer(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1   // pointer for nums1
        var j = n - 1   // pointer for nums2
        var k = nums1.size - 1  // pointer to set values in the array

        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--]
            else
                nums1[k--] = nums2[j--]
        }

        while(j >= 0) nums1[k--] = nums2[j--]
    }
}
