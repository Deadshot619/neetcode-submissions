class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        return usingHashMap(s, t)
    }

    fun usingHashMap(s: String, t: String): Boolean {
        val arr1 = IntArray(26){0}
        val arr2 = IntArray(26){0}

        for(i in s) {
            arr1[i - 'a'] = arr1[i - 'a'] + 1
        }

        for(i in t) {
            arr2[i - 'a'] = arr2[i - 'a'] + 1
        }

        if(arr1.contentEquals(arr2))
            return true
        else return false
    }
}
