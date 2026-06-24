class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        var good = HashSet<Int>() 

        for(t in triplets) {
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue

            t.forEachIndexed { i, v ->
                if(v == target[i])
                    good.add(i)
            }
        }

        return good.size == 3
    }
}
