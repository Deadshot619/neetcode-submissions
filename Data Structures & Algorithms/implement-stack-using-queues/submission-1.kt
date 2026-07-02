class MyStack() {
    val stack = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.addLast(x)
    }

    fun pop(): Int {
        repeat(stack.size - 1) {
            stack.addLast(stack.removeFirst())
        }
        return stack.removeFirst()
    }

    fun top(): Int {
        return stack.last()
    }

    fun empty(): Boolean {
        return stack.isEmpty()
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */
