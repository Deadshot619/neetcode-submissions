class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        return backtracking(coins, amount)
    }

    fun backtracking(coins: IntArray, amount: Int): Int {
        
        val res = mutableListOf<Int>()
        var minSize = Integer.MAX_VALUE

        fun dfs(i: Int, total: Int) {
            if(total == amount) {
                minSize = minOf(res.size, minSize)
            }

            if(i >= coins.size || total > amount) return

            res.add(i)
            dfs(i, total + coins[i])

            res.removeLast()
            dfs(i + 1, total)
        }

        dfs(0, 0)
        return if(minSize == Integer.MAX_VALUE) -1 else minSize
    }
}
