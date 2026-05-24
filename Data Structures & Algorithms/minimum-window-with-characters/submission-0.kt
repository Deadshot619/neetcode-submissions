class Solution {
    fun minWindow(s: String, t: String): String {
        val countT = HashMap<Char, Int>()

        for(c in t) {
            countT[c] = (countT[c] ?: 0) + 1
        }

        val countS = HashMap<Char, Int>()
        val need = countT.keys.size
        var have = 0

        var res = Pair(-1, -1)
        var resSize = Integer.MAX_VALUE

        var l = 0
        for(r in s.indices) {
            countS[s[r]] = (countS[s[r]] ?: 0) + 1

            if(countS[s[r]] == countT[s[r]]) {
                have++
            }

            while(need == have) {
                if(r - l + 1 < resSize) {
                    resSize = r - l + 1
                    res = Pair(l, r)
                }
                countS[s[l]] = (countS[s[l]] ?: 0) - 1

                if(countS[s[l]]!! + 1 == countT[s[l]]) {
                    have--
                }

                l++
            }
        }

        if(resSize != Integer.MAX_VALUE) 
            return s.substring(res.first, res.second + 1)
        else
            return ""
    }
}