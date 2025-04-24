package leet.code.medium

import leet.code.Solution
import java.util.PriorityQueue

class P355DesignTwitter : Solution {

    override fun test() {

    }

    class Twitter() {

        val tweets = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        val following = mutableMapOf<Int, MutableSet<Int>>()

        var timestamp = 0

        fun postTweet(userId: Int, tweetId: Int) {
            tweets.getOrPut(userId) { mutableListOf() }.add(Pair(tweetId, timestamp))
            timestamp++
        }

        fun getNewsFeed(userId: Int): List<Int> {
            val q = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
            for (t in tweets.getOrPut(userId) { mutableListOf() }) q.add(t)
            for (id in following.getOrPut(userId) { mutableSetOf() }) {
                for (t in tweets.getOrPut(id) { mutableListOf() }) q.add(t)
            }
            val feed = mutableListOf<Int>()
            for (i in 0..<10) {
                if (q.isEmpty()) break
                feed.add(q.poll().first)
            }

            return feed
        }

        fun follow(followerId: Int, followeeId: Int) {
            following.getOrPut(followerId) { mutableSetOf() }.add(followeeId)
        }

        fun unfollow(followerId: Int, followeeId: Int) {
            following.getOrPut(followerId) { mutableSetOf() }.remove(followeeId)
        }
    }
}
