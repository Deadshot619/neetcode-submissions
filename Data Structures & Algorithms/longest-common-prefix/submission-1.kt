class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        return checkSmallest(strs)
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
}
