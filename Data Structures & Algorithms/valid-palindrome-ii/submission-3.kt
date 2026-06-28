class Solution {
    fun validPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        var isDeleted = false

        while(l < r) {
            if(s[l] != s[r]) {
                return isValidPalin(s.substring(l + 1, r + 1)) ||
                    isValidPalin(s.substring(l, r)) 
            }

            l++
            r--
        }

        return true
    }

    fun isValidPalin(s: String): Boolean {
        var l = 0
        var r = s.length - 1

        while(l < r) {
            if(s[l] != s[r])
                return false
            l++
            r--
        }

        return true
    }
}
