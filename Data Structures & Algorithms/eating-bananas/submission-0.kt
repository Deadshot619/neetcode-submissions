class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.max()!!
        var res = r

        while (l <= r) {
            val k = (l + r) / 2
            var totalTime = 0L

            for (p in piles) {
                totalTime += Math.ceil(p.toDouble() / k).toLong()
            }

            if (totalTime <= h) {
                res = k
                r = k - 1
            } else {
                l = k + 1
            }
        }
        return res
    }
}
