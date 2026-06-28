class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var l1 = m - 1
        var l2 = n - 1
        var last = m + n - 1

        while(l1 >= 0 && l2 >= 0) {
            if(nums1[l1] <= nums2[l2]) {
                nums1[last] = nums2[l2]
                l2--
            } else {
                nums1[last] = nums1[l1]
                l1--
            }
            last--
        }

        while(l2 >= 0) {
            nums1[last] = nums2[l2]
            l2--
            last--
        }
    }
}
