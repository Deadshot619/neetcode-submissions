class Solution {
    fun letterCombinations(digits: String): List<String> {
        return backtracking(digits)
    }

    fun backtracking(digits: String): List<String> {
        if(digits.isEmpty()) return listOf<String>()

        val numToDigit = hashMapOf<String, String>(
            "2" to "abc",
            "3" to "def",
            "4" to "ghi",
            "5" to "jkl",
            "6" to "mno",
            "7" to "pqrs",
            "8" to "tuv",
            "9" to "wxyz",
        )

        val res = mutableListOf<String>()

        fun dfs(i: Int, curStr: String) {
            if(i >= digits.length) {
                res.add(curStr)
                return
            }

            for(c in numToDigit[digits[i].toString()]!!) {
                dfs(i + 1, curStr + c)
            }
        }
                   
        dfs(0, "")
        return res
    }
}
