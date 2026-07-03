class StockSpanner() {

    val stack = ArrayDeque<Pair<Int, Int>>() // num, index
    var c = 0

    fun next(price: Int): Int {
        var poppedItem: Pair<Int, Int>? = null

        while(stack.isNotEmpty() && stack.last().first <= price) {
            poppedItem = stack.removeLast()
        }

        val item = Pair(price, poppedItem?.second ?: c)
        stack.addLast(item)
        val res = if(poppedItem == null) 1 else c - poppedItem!!.second + 1
        c++
        return res
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * val obj = StockSpanner()
 * val param_1 = obj.next(price)
 */
