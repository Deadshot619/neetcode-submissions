class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var max = 0
        var l = 0
        val charMap = mutableMapOf<Char, Int>()

        for(r in 0 until s.length) {
            charMap[s[r]] = (charMap[s[r]] ?: 0) + 1

            // window length - max value of character count should be <= k
            while((r - l + 1) - charMap.values.max() > k) {
                charMap[s[l]] = (charMap[s[l]] ?: 0) - 1
                l++
            }

            max = maxOf(max, r - l + 1)
        }

        return max
    }
}
