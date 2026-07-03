class StockSpanner() {

    val stack = ArrayDeque<Pair<Int, Int>>() // num, index

    fun next(price: Int): Int {
        var span = 1

        while(stack.isNotEmpty() && stack.last().first <= price) {
            span += stack.removeLast().second
        }

        stack.addLast(Pair(price, span))
        return span
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * val obj = StockSpanner()
 * val param_1 = obj.next(price)
 */
