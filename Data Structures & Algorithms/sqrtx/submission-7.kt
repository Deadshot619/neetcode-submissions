class Solution {
    fun mySqrt(x: Int): Int {
        return binarySearch(x)
    }

    fun binarySearch(x: Int): Int {
        var l = 0
        var r = x
        var res = 0

        while(l <= r) {
            val mid = l + (r - l)/2
            val sq = mid.toLong() * mid

            if(sq > x) {
                r = mid - 1
            } else if(sq < x) {
                l = mid + 1
                res = mid
            } else
                return mid
        }

        return res
    }
}
