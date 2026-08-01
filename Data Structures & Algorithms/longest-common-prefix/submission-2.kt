class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        // return checkSmallest(strs)
        return neetCode(strs)
    }

    fun checkSmallest(strs: Array<String>): String {
        if(strs.size == 1) return strs[0]

        var str = strs[0]

        for(i in 0 until strs.size) {
            var temp = ""
            val checkStr = strs[i]
            for(j in 0 until str.length) {
                if(j == checkStr.length) break
                if(str[j] != checkStr[j]) break
                temp += str[j]
            }
            str = temp
        }

        return str
    }

    fun neetCode(strs: Array<String>): String {
        var res = ""

        for(i in 0 until strs[0].length) {
            for(s in strs) {
                if(i == s.length || s[i] != strs[0][i]) 
                    return res
            }
            res += strs[0][i]
        }

        return res
    }
}
