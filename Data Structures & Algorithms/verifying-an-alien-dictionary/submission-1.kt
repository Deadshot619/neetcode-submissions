class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        return compareAdjWords(words, order)
    }

    fun compareAdjWords(words: Array<String>, order: String): Boolean {
        val orderMap = HashMap<Char, Int>()
        order.forEachIndexed { i, c ->
            orderMap[c] = i
        }
        
        for(i in 0 until words.size - 1) {
            val w1 = words[i]
            val w2 = words[i + 1]

            for(j in 0 until w1.length) {
                if(j == w2.length) return false

                val c1 = orderMap[w1[j]]!!
                val c2 = orderMap[w2[j]]!!

                
                if(c1 != c2) {
                    if(c1 > c2) 
                        return false
                    break
                }
            }
        }

        return true
    }
}
