class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val temp = IntArray(temperatures.size)

        val stack = ArrayDeque<Pair<Int, Int>>()

        for(i in 0 until temperatures.size) {
            while(stack.size > 0 && stack.last().first < temperatures[i]){
                val t = stack.removeLast()
                temp[t.second] = i - t.second
            }
            stack.add(Pair(temperatures[i], i))
        }

        return temp
    }
}
