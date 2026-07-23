class Solution {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        return usingDisjointSetUnion(accounts)
    }

    fun usingDisjointSetUnion(accounts: List<List<String>>): List<List<String>> {
        val un = Union(accounts.size)

        val emailToAcc = HashMap<String, Int>()
        accounts.forEachIndexed { i, a ->
            for(e in a.slice(1 until a.size)) {
                if(e in emailToAcc){
                    un.union(i, emailToAcc[e]!!)
                } else {
                    emailToAcc[e] = i
                }
            }
        }

        val emailGroup = HashMap<Int, MutableList<String>>()
        for((e, i) in emailToAcc) {
            val leader = un.find(i)
            if(leader !in emailGroup){
                emailGroup[leader] = mutableListOf()
            }
            emailGroup[leader]?.add(e)
        }

        val res = mutableListOf<List<String>>()
        for((accId, emails) in emailGroup) {
            val name = accounts[accId][0]
            emails.sort()
            res.add(listOf(name) + emails)
        }

        return res
    }
}

class Union(val n: Int) {
    val parent = MutableList(n){ it }
    val rank = MutableList(n) { 1 }

    fun find(i: Int): Int { // find and/or reassign the parent
        var cur = i
        while(cur != parent[cur]) {
            parent[cur] = parent[parent[cur]]
            cur = parent[cur]
        }
        return cur
    }

    fun union(i: Int, j: Int): Boolean {
        val pi = find(i)
        val pj = find(j)

        if(pi == pj) return false

        if(rank[pj] > rank[pi]) {
            parent[pi] = pj
            rank[pj]++
        } else {
            parent[pj]= pi
            rank[pi]++
        }

        return true
    }
}
