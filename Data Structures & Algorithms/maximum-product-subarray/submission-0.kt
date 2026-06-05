class Solution {
    fun maxProduct(nums: IntArray): Int {
        var res = nums.max()
        var min = 1 // current min
        var max = 1 // current max

        nums.forEach { n ->
            if(n == 0) {
                min = 1
                max = 1
            }

            val temp = n * max
            max = maxOf(temp, n * min, n)
            min = minOf(temp, n * min, n)
            res = maxOf(res, max)
        }

        return res
    }
}
