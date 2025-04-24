package leet.code.medium

import leet.code.Solution

class P207CourseSchedule : Solution {

    override fun test() {
        println(
            canFinish(
                5,
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(2, 4),
                    intArrayOf(3, 1),
                    intArrayOf(3, 2),
                )
            )
        )
    }

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = prerequisites.groupByTo(mutableMapOf(), { it[0] }, { it[1] })
        val visited = BooleanArray(numCourses)

        fun hasCycle(course: Int): Boolean {
            val then = graph[course]
            if (then.isNullOrEmpty()) {
                return false
            }

            if (visited[course]) {
                return true
            }
            visited[course] = true

            for (c in then) {
                if (hasCycle(c)) return true
            }

            graph[course] = mutableListOf()
            return false
        }

        for (course in 0 until numCourses) {
            if (hasCycle(course)) {
                return false
            }
        }

        return true
    }
}