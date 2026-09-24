class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        return binarySearch(piles, h)
    }

    fun binarySearch(piles: IntArray, h: Int): Int {
        var l = 0
        var r = piles.max()
        var res = r

        while(l <= r) {
            val mid = l + (r - l)/2
            var hours = 0

            for(p in piles) {
                hours += ceil(p/mid.toDouble()).toInt()
            }

            if(hours <= h && hours > 0) {
                res = min(res, mid)
                r = mid - 1
            } else l = mid + 1
        }

        return res
    }
}
