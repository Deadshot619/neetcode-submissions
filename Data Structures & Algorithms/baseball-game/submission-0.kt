class Solution {
    fun calPoints(operations: Array<String>): Int {
        return usingStack(operations)
    }

    fun usingStack(operations: Array<String>): Int {
        val stack = mutableListOf<Int>()

        fun opr(op: String) {
            when(op) {
                "D" -> stack.add(stack.last() * 2)
                "+" -> stack.add(
                        stack.last() + stack[stack.size - 2]
                    )
                "C" -> stack.removeLast()
                else -> stack.add(op.toInt())
            }
        }

        for(s in operations) {
            opr(s)
        }

        var res = 0
        for(n in stack) {
            res += n
        }
        return res
    }
}
