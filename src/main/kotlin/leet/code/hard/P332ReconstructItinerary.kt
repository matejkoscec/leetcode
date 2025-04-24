package leet.code.hard

import leet.code.Solution
import java.util.*


class P332ReconstructItinerary : Solution {

    override fun test() {

    }

    fun findItinerary(tickets: List<List<String>>): List<String> {
        val targets = mutableMapOf<String, PriorityQueue<String>>()
        for ((a, b) in tickets) {
            targets.getOrPut(a) { PriorityQueue() }.add(b)
        }

        val route = mutableListOf<String>()

        fun trace(airport: String) {
            val q = targets[airport]
            while (q != null && !q.isEmpty()) {
                trace(q.poll())
            }
            route.add(0, airport)
        }

        trace("JFK")

        return route
    }
}
