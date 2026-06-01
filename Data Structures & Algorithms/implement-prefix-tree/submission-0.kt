
data class TrieNode(
    val children: MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>(),
    var isEnd: Boolean = false
)

class PrefixTree {

    val root = TrieNode()

    fun insert(word: String) {
        var cur = root
        for(c in word) {
            if(cur.children[c] == null){
                cur.children[c] = TrieNode()
            }
            cur = cur.children[c]!!
        }
        cur.isEnd = true
    }

    fun search(word: String): Boolean {
        var cur = root
        for(c in word) {
            if(cur.children[c] == null){
                return false
            }
            cur = cur.children[c]!!
        }
        return cur.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        for(c in prefix) {
            if(cur.children[c] == null){
                return false
            }
            cur = cur.children[c]!!
        }
        return true
    }
}