class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return usingHashMap(strs)
    }

    fun usingHashMap(strs: Array<String>): List<List<String>> {
        val mapAnagram = HashMap<List<Int>, MutableList<String>>()

        for(str in strs) {
            val count = MutableList(26){0}
            for(c in str) {
                count[c - 'a']++
            }
            mapAnagram.getOrPut(count) {mutableListOf()}.add(str)
        }

        return mapAnagram.values.toList()
    }
}
