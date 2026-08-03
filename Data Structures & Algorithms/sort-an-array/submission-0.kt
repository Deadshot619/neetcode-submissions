class Solution {
    fun sortArray(nums: IntArray): IntArray {
        return mergeSort(nums)
    }  

    fun mergeSort(nums: IntArray): IntArray {
        if(nums.size <= 1) return nums
        
        val mid = nums.size / 2
        val left = mergeSort(nums.sliceArray(0 until mid))
        val right = mergeSort(nums.sliceArray(mid until nums.size))
        return merge(left, right)
    }

    fun merge(arr1: IntArray, arr2: IntArray): IntArray {
        val res = IntArray(arr1.size + arr2.size)

        var a = 0
        var b = 0
        var c = 0
        while(a < arr1.size && b < arr2.size) {
            if(arr1[a] <= arr2[b])
                res[c++] = arr1[a++]
            else
                res[c++] = arr2[b++]
        }

        while(a < arr1.size) {
            res[c++] = arr1[a++]
        }
        while(b < arr2.size) {
            res[c++] = arr2[b++]
        }
        
        return res
    }
}
