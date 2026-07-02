class MyQueue() {
    val s1 = ArrayDeque<Int>()
    val s2 = ArrayDeque<Int>()

    private fun fillS2fromS1() {
        while(s1.isNotEmpty()) {
            s2.addLast(s1.removeLast())
        }
    }

    fun push(x: Int) {
        s1.addLast(x)
    }

    fun pop(): Int {
        if(s2.isEmpty())
            fillS2fromS1()
        return s2.removeLast()
    }

    fun peek(): Int {
        if(s2.isEmpty())
            fillS2fromS1()
        return s2.last()
    }

    fun empty(): Boolean {
        return s1.isEmpty() && s2.isEmpty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * val obj = MyQueue()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.peek()
 * val param_4 = obj.empty()
 */
