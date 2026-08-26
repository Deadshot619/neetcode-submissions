class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        return twoPointer(word1, word2)
    }

    fun twoPointer(word1: String, word2: String): String {
        var a = 0
        var b = 0
        var res = ""

        while(a < word1.length && b < word2.length) {
            res += word1[a++]
            res += word2[b++]
        }

        if(a == word1.length) res += word2.substring(b, word2.length)
        if(b == word2.length) res += word1.substring(a, word1.length)

        return res
    }
}
