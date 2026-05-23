class TimeMap() {

    val timeMap = mutableMapOf<String, MutableList<Pair<String, Int>>>()
    
    fun set(key: String, value: String, timestamp: Int) {
        if(timeMap[key] == null) {
            timeMap[key] = mutableListOf()
        }
        timeMap[key]!!.add(Pair(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        val values = timeMap[key] ?: return ""
        var res = ""
        var l = 0
        var r = values.size - 1

        while(l <= r) {
            val mid = l + (r-l)/2

            if(values[mid].second <= timestamp) {
                res = values[mid].first
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return res
    }
}
