class MinStack() {
    val stack = ArrayDeque<Pair<Int, Int>>()

    fun push(`val`: Int) {
        val min = minOf(stack.lastOrNull()?.second ?: Integer.MAX_VALUE, `val`)
        stack.addLast(Pair(`val`, min))
    }

    fun pop() {
        if(stack.isNotEmpty())
            stack.removeLast()
    }

    fun top(): Int {
        if(stack.isNotEmpty())
            return stack.last().first
        return -1
    }

    fun getMin(): Int {
        if(stack.isNotEmpty())
            return stack.last().second
        return -1
    }
}
