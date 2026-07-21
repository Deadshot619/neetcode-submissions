class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {
        return backtracking(deadends, target)
    }

    fun backtracking(deadends: Array<String>, target: String): Int {

        val q = ArrayDeque<Pair<String, Int>>()
        q.add(Pair("0000", 0))

        val visit = mutableSetOf<String>()
        visit.addAll(deadends)

        if("0000" in visit) return -1

        fun children(code: String): List<String> {
            val codes = mutableListOf<String>()
            for(i in 0 until 4) {
                val c = code[i].toString().toInt()
                val add = (c + 1 + 10) % 10
                val sub = (c + 9) % 10
                codes.add(
                    code.substring(0, i) + add + code.substring(i + 1, 4)
                )
                codes.add(
                    code.substring(0, i) + sub + code.substring(i + 1, 4)
                )
            }
            return codes
        }

        while(q.isNotEmpty()) {
            val (code, steps) = q.removeFirst()

            if(code == target) return steps

            for(c in children(code)) {
                if(c in visit) continue
                visit.add(c)
                q.add(Pair(c, steps + 1))
            }
        }

        return -1
    }
}
