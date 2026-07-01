class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        return optimal(people, limit)
    }

    fun optimal(people: IntArray, limit: Int): Int {
        people.sort()

        var l = 0
        var r = people.size - 1

        var c = 0

        while(l <= r) {
            val sum = people[l] + people[r]

            if(sum > limit) { 
                r--
            } else {
                l++
                r--
            }
            c++
        }

        return c
    }
}
