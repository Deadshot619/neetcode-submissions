class Solution {
    fun simplifyPath(path: String): String {
        return bruteForce(path)
    }

    fun bruteForce(path: String): String {
        if(path.length < 2) return path

        val stack = ArrayDeque<String>()

        var l = 0
        var r = 0

        while(l < path.length) {
            while(r < path.length && path[r] != '/') {
                r++   
            }
            val s = path.substring(l, r)
            l = r

            if(s == ".." && stack.isNotEmpty())
                stack.removeLast()
            else if (s != "" && s != "/" && s != ".." && s != ".")
                stack.addLast(s)

            while(r < path.length && path[r] == '/'){
                r++
                l++
            }
        }

        return '/' + stack.joinToString("/")
    }
}
