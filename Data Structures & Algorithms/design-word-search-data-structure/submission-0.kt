data class TrieNode(
    val children: HashMap<Char, TrieNode> = hashMapOf<Char, TrieNode>(),
    var endOfWord: Boolean = false
)

class WordDictionary {

    val root = TrieNode()

    fun addWord(word: String) {
        var cur = root
        for(c in word) {
            if(cur.children[c] == null) {
                cur.children[c] = TrieNode()
            }
            cur = cur.children[c]!!
        }
        cur.endOfWord = true
    }

    fun search(word: String): Boolean {

        fun dfs(j: Int, node: TrieNode): Boolean {  
            var cur = node

            for(i in j until word.length) {
                val c = word[i]
                if (c == '.') {
                    for(childNode in cur.children.values) {
                        if(dfs(i + 1, childNode)) {
                            return true
                        }
                    }
                    return false
                } else if(cur.children[c] == null) {
                    return false
                } 
                cur = cur.children[c]!!
            }

            return cur.endOfWord
        }

        return dfs(0, root)
    }
}
