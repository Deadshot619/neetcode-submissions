class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val row = Array(9) { HashSet<Char>() }
        val col = Array(9) { HashSet<Char>() }
        val box = Array(9) { HashSet<Char>() }

        for(r in 0..8) {
            for(c in 0..8) {
                if(board[r][c] == '.') continue

                val num = board[r][c]
                val boxIndex = (r / 3) * 3 + (c / 3)
                println(boxIndex)
                if(num in row[r] || num in col[c] || num in box[boxIndex])
                    return false

                row[r].add(num)
                col[c].add(num)
                box[boxIndex].add(num)
            }
        }

        return true
    }
}
