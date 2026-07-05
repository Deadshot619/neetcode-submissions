/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     fun get(index: Int): Int
 *     fun length(): Int
 * }
 */

class Solution {
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        return binarySearch(target, mountainArr)
    }

    fun binarySearch(target: Int, mountainArr: MountainArray): Int {
        var length = mountainArr.length()

        //Find peak
        var l = 1
        var r = length - 2
        var peak = 0

        while(l <= r) {
            val m = l + (r-l)/2
            val left = mountainArr.get(m - 1)
            val mid = mountainArr.get(m)
            val right = mountainArr.get(m + 1)

            if(left < mid && mid < right) {
                l = m + 1
            } else if(left > mid && mid > right) {
                r = m - 1
            } else {
                peak = m
                break
            }
        }

        // Search Left
        l = 0
        r = peak

        while(l <= r) {
            val m = l + (r - l)/2
            val midValue = mountainArr.get(m)

            if(midValue == target) return m

            if(target > midValue)
                l = m + 1
            else
                r = m - 1
        }

        // Search Right
        l = peak + 1
        r = length - 1

        while(l <= r) {
            val m = l + (r - l)/2
            val midValue = mountainArr.get(m)

            if(midValue == target) return m

            if(target < midValue)
                l = m + 1
            else
                r = m - 1
        }

        return -1
    }
}