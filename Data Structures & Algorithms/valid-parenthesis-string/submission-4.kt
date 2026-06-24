class Solution {
    fun checkValidString(s: String): Boolean {
    //    return recursion(s)
    //    return topDown(s)
        return greedy(s)
    }

    fun recursion(s: String): Boolean {  

        fun dfs(i: Int, left: Int): Boolean {
            if(i >= s.length) {
                if(left == 0)
                    return true
                else 
                    return false
            }

            if(left < 0) return false

            var res = false
            
            if(s[i] == '(') {
                res = dfs(i + 1, left + 1)
            } else if(s[i] == ')') {
                res = dfs(i + 1, left - 1)
            } else {
                res = dfs(i + 1, left + 1) || dfs(i + 1, left - 1) || dfs(i + 1, left)
            }

            return res
        }

        return dfs(0, 0)
    }

    fun topDown(s: String): Boolean {  
        val dp = HashMap<Pair<Int, Int>, Boolean>()

        fun dfs(i: Int, left: Int): Boolean {
            if(i >= s.length) {
                if(left == 0)
                    return true
                else 
                    return false
            }

            if(left < 0) return false

            if(Pair(i, left) in dp) return dp[Pair(i, left)]!!

            var res = false
            
            if(s[i] == '(') {
                res = dfs(i + 1, left + 1)
            } else if(s[i] == ')') {
                res = dfs(i + 1, left - 1)
            } else {
                res = dfs(i + 1, left + 1) || dfs(i + 1, left - 1) || dfs(i + 1, left)
            }

            dp[Pair(i, left)] = res

            return res
        }

        return dfs(0, 0)
    }

    fun greedy(s: String): Boolean {  
       var leftMin = 0
       var leftMax = 0

       for(c in s) {
            if(c == '(') {
                leftMin++
                leftMax++
            } else if(c == ')') {
                leftMin--
                leftMax--
            } else {
                leftMin--
                leftMax++
            }

            if(leftMin < 0) leftMin = 0
            if(leftMax < 0) return false
       }

       return leftMin == 0
    }
}
