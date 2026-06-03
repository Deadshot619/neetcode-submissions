class Solution {
    fun longestPalindrome(s: String): String {
        var longest = 0
        var longPal = ""

        fun isPalin(i: Int, j: Int) {
            var l = i
            var r = j

            while(l >= 0 && r < s.length && s[l] == s[r]) {
                    if(r - l + 1 > longest) {
                        longest = r - l + 1
                        longPal = s.substring(l, r + 1)
                    }
                l--
                r++
            }
        }

        for(i in 0 until s.length) {
            isPalin(i, i)
            isPalin(i, i + 1)
        }

        return longPal
    }    

}
