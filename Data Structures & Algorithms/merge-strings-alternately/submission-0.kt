class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var l1 = 0
        var l2 = 0

        var res = ""

        while(l1 < word1.length && l2 < word2.length) {
            res += word1[l1]
            res += word2[l2]

            l1++
            l2++
        }

        if(l1 < word1.length) res += word1.substring(l1, word1.length)
        if(l2 < word2.length) res += word2.substring(l2, word2.length)

        return res
    }
}
