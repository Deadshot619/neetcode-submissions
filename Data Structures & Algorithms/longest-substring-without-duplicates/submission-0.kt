class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var l = 0
        var r = 0
        val chars = mutableSetOf<Char>()
        var max = 0

        while(r < s.length) {
            if(s[r] !in chars) {
                chars.add(s[r])
                r++
            } else {
                chars.remove(s[l])
                l++
            }
            max = maxOf(max, chars.size)
        }

        return max
    }
}
