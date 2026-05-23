class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        return bruteForce(nums1, nums2)
    }

    fun bruteForce(nums1: IntArray, nums2: IntArray): Double {
        var nums3 = IntArray(nums1.size + nums2.size)

        var l = 0
        var r = 0
        var k = 0

        while(l < nums1.size && r < nums2.size) {
            if(nums1[l] <= nums2[r]) {
                nums3[k] = nums1[l]
                l++
            } else {
                nums3[k] = nums2[r]
                r++
            }
            k++
        }

        while(l < nums1.size) {
            nums3[k++] = nums1[l++]
        }

        while(r < nums2.size) {
            nums3[k++] = nums2[r++]
        }

        var mid = (nums3.size - 1) / 2
        return if(nums3.size % 2 == 0) {
            (nums3[mid] + nums3[mid + 1])/2.0
        } else {
            nums3[mid].toDouble()
        }
    }
}
