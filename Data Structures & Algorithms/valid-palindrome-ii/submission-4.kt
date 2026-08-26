class Solution {
    fun validPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1

        while(l <= r) {
            if(s[l] != s[r]) {
                return isValid(s.substring(l, r)) || 
                    isValid(s.substring(l + 1, r + 1))
            }
            l++
            r--
        }

        return true
    }

    fun isValid(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while(l <= r) {
            if(s[l] != s[r]) return false
            l++
            r--
        }
        return true
    }
}
