class Solution {
    fun maxArea(heights: IntArray): Int {
        return twoPointers(heights)
    }

    fun twoPointers(heights: IntArray): Int {
        var maxV = 0

        var l = 0
        var r = heights.size - 1

        while(l < r) {
            val area = min(heights[l], heights[r]) * (r - l)
            maxV = max(maxV, area)
            if(heights[l] > heights[r])
                r--
            else
                l++
        }

        return maxV
    }
}
