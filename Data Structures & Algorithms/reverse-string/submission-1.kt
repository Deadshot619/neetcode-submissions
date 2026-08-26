class Solution {
    fun reverseString(s: CharArray) {
        twoPointers(s)
    }

    fun twoPointers(s: CharArray) {
        if(s.size <= 1) return

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
