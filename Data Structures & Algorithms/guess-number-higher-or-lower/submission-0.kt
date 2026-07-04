/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num: Int): Int
 */

class Solution : GuessGame() {

    fun guessNumber(n: Int): Int {
        return binarySearch(n)
    }

    fun binarySearch(n: Int): Int {
        var l = 0
        var r = n

        while(l <= r) {
            val mid = l + (r - l)/2
            val g = guess(mid)

            if(g == 0) return mid

            if(g == 1) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return 0
    }
}
