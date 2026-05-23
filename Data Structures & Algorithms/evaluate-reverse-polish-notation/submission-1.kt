class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        val opr = setOf("+", "-", "*", "/")

        for(t in tokens) {
            if(t in opr) {
                val num2 = stack.removeLast()
                val num1 = stack.removeLast()
                
                var total = performOperation(num1, num2, t)
                stack.addLast(total)
            } else {
                stack.addLast(t.toInt())
            }
        }

        return stack.removeLast()
    }

    fun performOperation(num1: Int, num2: Int, opr: String): Int {
        return when(opr) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            else -> num1 / num2
        }
    }
}