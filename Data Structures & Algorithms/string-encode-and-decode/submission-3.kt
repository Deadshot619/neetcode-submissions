class Solution {

    fun encode(strs: List<String>): String {
        val res = StringBuilder()
        for (str in strs) {
            res.append(str.length).append('#').append(str)
        }
        return res.toString()
    }

    fun decode(str: String): List<String> {
        var l = 0
        var r = 0
        val result = mutableListOf<String>()

        while(l < str.length || r < str.length) {
            while(str[r] != '#') {
                r++
            }
            var size = str.substring(l, r).toInt()
            var retStr = str.substring(r+1, r+1+size)
            result.add(retStr)
            l = r + 1 + size
            r = r + 1 + size
        }

        return result
    }
}
