class Solution {
    fun partitionLabels(s: String): List<Int> {
        val lastIndex = HashMap<Char, Int>()

        for(i in s.indices) {
            lastIndex[s[i]] = i
        }

        var size = 0
        var end = 0
        val res = mutableListOf<Int>()

        s.forEachIndexed { i, c ->
            size++

            end = max(end, lastIndex[c]!!)

            if(i == end) {
                res.add(size)
                size = 0
            }
        }

        return res
    }
}
