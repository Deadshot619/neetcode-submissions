class FreqStack() {
    val freq = HashMap<Int, Int>() // Num added to count
    var maxC = 0    // max count
    val stacks = HashMap<Int, ArrayList<Int>>() // Count to list of numbers added as stack

    fun push(`val`: Int) {
        freq[`val`] = (freq[`val`] ?: 0) + 1
        maxC = max(maxC, freq[`val`]!!)

        if(stacks[freq[`val`]] == null)
            stacks[freq[`val`]!!] = arrayListOf()
        stacks[freq[`val`]]?.addLast(`val`)
    }

    fun pop(): Int {
        val value = stacks[maxC]!!.removeLast()
        if(stacks[maxC]!!.isEmpty())
            maxC--
        freq[value] = freq[value]!! - 1
        return value
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * val obj = FreqStack()
 * obj.push(`val`)
 * val param_2 = obj.pop()
 */
