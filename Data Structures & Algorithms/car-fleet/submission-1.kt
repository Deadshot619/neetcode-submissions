class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val posSpeedPair = mutableListOf<Pair<Int, Int>>()

        for(i in position.indices) {
            posSpeedPair.add(Pair(position[i], speed[i]))
        }

        posSpeedPair.sortByDescending { it.first }

        val timeStack = ArrayDeque<Float>()

        for(car in posSpeedPair) {
            val time = (target - car.first).toFloat()/car.second

            if(timeStack.isEmpty() || time > timeStack.last()) {
                timeStack.addLast(time)
            }
        }

        return timeStack.size
    }
}
