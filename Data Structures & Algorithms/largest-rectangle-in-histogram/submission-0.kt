class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Pair<Int, Int>>() // Index to Height
        var maxArea = 0

        heights.forEachIndexed { i, h -> 
            var start = i
            while(stack.isNotEmpty() && stack.last().second > h) {
                val (i2, h2) = stack.removeLast()
                val area = h2 * (i - i2)
                start = i2
                maxArea = maxOf(maxArea, area)
            }
            stack.addLast(Pair(start, h))
        }

        while(stack.isNotEmpty()) {
            var (i, h) = stack.removeLast()
            val area = h * (heights.size - i)
            maxArea = maxOf(maxArea, area)
        }

        return maxArea
    }
}
