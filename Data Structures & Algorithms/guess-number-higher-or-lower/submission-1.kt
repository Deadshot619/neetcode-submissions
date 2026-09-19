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
        var l = 0
        var r = n

        while(l <= r){
            var mid = l + (r - l)/2
            val target = guess(mid)

            if(target == -1) r = mid - 1
            else if(target == 1) l = mid + 1
            else return mid
        }

        return -1
    }
}
