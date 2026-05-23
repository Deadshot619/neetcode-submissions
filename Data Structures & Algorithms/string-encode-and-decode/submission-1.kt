class Solution {

    fun encode(strs: List<String>): String {
        var str = ""

        for(s in strs) {
            str = str + "${s.length}#$s"
        }

        return str
    }

    fun decode(str: String): List<String> {
        println(str)
        val ans = mutableListOf<String>()

        var start = 0
        var end = 0

        while(start < str.length) {
            end = start
            while (str[end] != '#') {
                end++
            }
            val len = str.substring(start, end).toInt()
            println(len)
            println(str.substring(end+1, end+1+len))
            if(len > 0)
                ans.add(str.substring(end+1, end+1+len))
            else
                ans.add("")
            start = end + len + 1 
        }
        return ans
    }
}
