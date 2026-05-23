class Solution {
    fun maxProfit(prices: IntArray): Int {
        var l = 0
        var r = 1

        var max = 0

        while(r < prices.size) {
            if(prices[l] > prices[r]) {
                l = r
            } else {
                max = maxOf(max, prices[r] - prices[l])
            }
            r++
        }

        return max
    }
}
