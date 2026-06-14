class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        return bfs1(beginWord, endWord, wordList)
    }

    fun bfs1(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        if(endWord !in wordList) return 0

        wordList.add(beginWord)

        val adj = HashMap<String, MutableList<String>>()

        wordList.forEach {
            adj[it] = mutableListOf<String>()
        }

        wordList.forEachIndexed { i, w -> 
            for(j in i + 1 until wordList.size) {
                val w2 = wordList[j]
                var diff = 0
                for(k in 0 until w.length) {
                    if(w[k] != w2[k]) 
                        diff++
                }
                if(diff == 1) {
                    adj[w]?.add(w2)
                    adj[w2]?.add(w)
                }
            }
        }

        val q = ArrayDeque<String>()
        val visited = HashSet<String>()
        q.add(beginWord)
        visited.add(beginWord)

        var res = 1
        
        while(q.isNotEmpty()) {
            repeat(q.size) {
                val w = q.removeFirst()

                if(w == endWord) return res

                for(n in adj[w] ?: listOf()){
                    if(n in visited) continue

                    q.add(n)
                    visited.add(n)
                }
            }
            res++
        }

        return 0
    }
}
