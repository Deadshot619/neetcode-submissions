class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        return usingHashMap(s, t)
    }

    fun usingHashMap(s: String, t: String): Boolean {
        if(s.length != t.length)
            return false

        val c1 = HashMap<Char, Int>()
        val c2 = HashMap<Char, Int>()

        for(i in s) {
            c1[i] = (c1[i] ?: 0) + 1
        }

        for(i in t) {
            c2[i] = (c2[i] ?: 0) + 1
        }

        return c1 == c2
    }
}
