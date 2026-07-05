class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
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
                curCap -= w
            }

            return ships <= days
        }   

        while(l <= r) {
            val cap = l + (r - l)/2     // capacity
            if(canShip(cap)) {
                res = min(res, cap)
                r = cap - 1
            } else {
                l = cap + 1
            }
        }

        return res
    }

     
}
