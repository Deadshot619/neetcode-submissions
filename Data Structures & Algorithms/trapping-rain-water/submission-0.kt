class Solution {
    fun trap(height: IntArray): Int {
        if(height.isEmpty()) return 0

        val prefixMaxHeight = mutableListOf<Int>()
        var max = 0
        for(h in height) {
            max = maxOf(max, h)
            prefixMaxHeight.add(max)
        }

        val suffixMaxHeight = IntArray(height.size)
        max = 0
        for(i in height.size-1 downTo 0) {
            max = maxOf(max, height[i])
            suffixMaxHeight[i] = max
        }

        var total = 0
        for(i in 0 until height.size) {
            total += (minOf(prefixMaxHeight[i], suffixMaxHeight[i]) - height[i])
        }

        return total
    }
}
