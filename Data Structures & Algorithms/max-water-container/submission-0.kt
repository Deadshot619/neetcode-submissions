class Solution {
    fun maxArea(heights: IntArray): Int {
        var maxArea = 0

        var l = 0
        var r = heights.size - 1

        while(l < r) {
            var minHeight = minOf(heights[l], heights[r])
            var area = minHeight * (r - l)

            maxArea = maxOf(maxArea, area)

            if(heights[l] >= heights[r]) {
                r--
            } else {
                l++
            }
        }

        return maxArea
    }
}
