class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        return checkJudge(n, trust)
    }

    fun checkJudge(n: Int, trust: Array<IntArray>): Int {
        val incoming = HashMap<Int, Int>()
        val outgoing = HashMap<Int, Int>()

        for((src, dest) in trust) {
            incoming[dest] = (incoming[dest] ?: 0) + 1
            outgoing[src] = (outgoing[src] ?: 0) + 1
        }

        for(i in 1..n) {
            if(incoming[i] == n - 1 && (outgoing[i] ?: 0) == 0){
                return i         
            }
        }

        return -1
    }
}
