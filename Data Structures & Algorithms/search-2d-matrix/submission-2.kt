class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        return binarySearch(matrix, target)
    }

    fun binarySearch(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        var r = matrix.size - 1
        var mid = (l + r)/2

        while(l <= r) {
            mid = (l + r)/2

            if(target > matrix[mid].last())
                l = mid + 1
            else if(target < matrix[mid].first())
                r = mid - 1
            else break
        }

        l = 0
        r = matrix[mid].size - 1
        val arr = matrix[mid]

        while(l <= r){
            mid = (l + r)/2

            if(target > arr[mid]) l = mid + 1
            else if(target < arr[mid]) r = mid - 1
            else return true
        }

        return false
    }
}
