class Solution {
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()

        val bracketMap = mapOf(
            '}' to '{',
            ']' to '[',
            ')' to '('
            )

        for(c in s) {
            if(c in bracketMap) {
                if(stack.isNotEmpty() && stack.last() == bracketMap[c])
                    stack.removeLast()
                else
                    return false
            } else {
                stack.add(c)
            }
        }

        return stack.isEmpty()
    }
}
