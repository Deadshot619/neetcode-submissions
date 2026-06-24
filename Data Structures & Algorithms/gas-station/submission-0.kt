class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if(gas.sum() < cost.sum())
            return -1

        var total = 0
        var start = 0
        for(i in gas.indices) {
            total += (gas[i] - cost[i])

            if(total < 0) {
                total = 0
                start = i + 1
            }
        }

        return start
    }
}
