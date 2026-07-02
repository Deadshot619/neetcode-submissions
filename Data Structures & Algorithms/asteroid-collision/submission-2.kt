class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = mutableListOf<Int>()

        for(a in asteroids) {
            var cur = a
            while(stack.isNotEmpty() && cur < 0 && stack.last() > 0) {
                val sum = cur + stack.last()
                if(sum < 0) {
                    stack.removeLast()
                } else if(sum > 0) {
                    cur = 0
                } else {
                    cur = 0
                    stack.removeLast()
                }
            }
            if(cur != 0)
                stack.addLast(cur)
        }

        return stack.toIntArray()
    }
}
