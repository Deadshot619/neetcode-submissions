class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if(hand.size % groupSize != 0) return false

        val count = HashMap<Int, Int>()
        for(n in hand) {
            count[n] = (count[n] ?: 0) + 1
        }

        val h = PriorityQueue<Int>().apply{
            addAll(count.keys)
        }


        while(h.isNotEmpty()) {
            val n = h.first()

            for(i in n until n + groupSize) {
                if(i !in count || count[i] == 0) return false

                count[i] = count[i]!! - 1
                if(count[i] == 0) {
                    if(i != h.first()){
                        return false
                    } else {
                        h.poll()
                    }
                }            
            }
        }

        return true
    }
}