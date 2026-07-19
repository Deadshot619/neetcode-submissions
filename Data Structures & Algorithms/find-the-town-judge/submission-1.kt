class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        return checkJudge(n, trust)
    }

    fun checkJudge(n: Int, trust: Array<IntArray>): Int {
        val inc = HashMap<Int, MutableList<Int>>()
        val outg = HashMap<Int, MutableList<Int>>()

        for((t1, t2) in trust) {
            if(t1 !in inc)
                inc[t1] = mutableListOf()
            if(t2 !in outg)
                outg[t2] = mutableListOf()
            inc[t1]?.add(t2)
            outg[t2]?.add(t1)
        }

        for(i in 1..n) {
            if(i in outg && (outg[i]?.size) ?: 0 == n - 1) {
                if(i !in inc)
                    return i
            }
        }

        return -1
    }
}
