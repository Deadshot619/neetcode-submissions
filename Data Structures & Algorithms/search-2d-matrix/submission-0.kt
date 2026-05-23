class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        var r = matrix.size - 1
        var innerSize = matrix[0].size - 1

        var innerMatrixPos = -1
        while(l <= r) {
            val mid = l + (r-l)/2

            if(target >= matrix[mid][0] && 
                target <= matrix[mid][innerSize]) {
                innerMatrixPos = mid
                break
            } else if (target < matrix[mid][0]) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        if(innerMatrixPos == -1) return false

        val resMatrix = matrix[innerMatrixPos]
        l = 0
        r = innerSize
        
        while(l <= r) {
            val mid = l + (r - l)/2
            if(target == resMatrix[mid])
                return true
            else if (target > resMatrix[mid])
                l = mid + 1
            else r = mid - 1
        }

        return false
    }
}
