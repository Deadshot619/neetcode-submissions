class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        return binarySearch(weights, days)
    }

    fun binarySearch(weights: IntArray, days: Int): Int {
        var l = weights.max()
        var r = weights.sum()
        var res = r

        fun canShip(cap: Int): Boolean {
            var ships = 1
            var curCap = cap
            for(w in weights) {
                if(curCap - w < 0) {
                    ships++
                    curCap = cap
                }
                curCap = curCap - w
            }

            return ships <= days
        }

        while(l <= r){
            val mid = (r + l)/2
            if(canShip(mid)) {
                res = min(res, mid)
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        return res
    }
}