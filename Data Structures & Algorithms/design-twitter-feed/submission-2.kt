class Twitter {

    var count = 0
    val users = mutableMapOf<Int, MutableSet<Int>>()
    val tweetMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>() // user to List<Pair<tweetId, Time>>

    fun postTweet(userId: Int, tweetId: Int) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap[userId] = mutableListOf()
        }
        tweetMap[userId]?.add(Pair(tweetId, count++))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val res = mutableListOf<Int>()
        val maxHeap = PriorityQueue<IntArray>(compareByDescending {it[0]})

        if (!users.containsKey(userId)) {
            users[userId] = HashSet()
        }
        users[userId]?.add(userId)

        users[userId]?.forEach { followeeId ->
            tweetMap[followeeId]?.let { 
                if(it.isNotEmpty()) {
                    val index = it.size - 1
                    val (tweetId, count) = it[index]
                    maxHeap.add(intArrayOf(count, tweetId, followeeId, index - 1))
                }
            }
        }

        while(maxHeap.isNotEmpty() && res.size < 10) {
            val (count, tweetId, followeeId, nextIndex) = maxHeap.poll()
            res.add(tweetId)

            if(nextIndex >= 0) {
                val tweets = tweetMap[followeeId]!!
                val (nextTweetId, nextCount) = tweets[nextIndex]
                maxHeap.add(intArrayOf(nextCount, nextTweetId, followeeId, nextIndex - 1))
            }
        }

        return res
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (!users.containsKey(followerId)) {
            users[followerId] = mutableSetOf()
        }
        users[followerId]?.add(followeeId)
        println(users[followerId])
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        users[followerId]?.remove(followeeId)
    }
}
