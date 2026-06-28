class Solution {
    fun reverseString(s: CharArray) {
        twoPointer(s)
    }

    fun twoPointer(s: CharArray) {
        var l = 0
        var r = s.size - 1

        while(l < r) {
            val temp = s[l]
            s[l] = s[r]
            s[r] = temp

            l++
            r--
        }
    }
}
