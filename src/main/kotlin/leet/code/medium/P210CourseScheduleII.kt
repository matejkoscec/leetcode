package leet.code.medium

import leet.code.Solution

class P210CourseScheduleII : Solution {

    override fun test() {

    }

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val deps = (0..<numCourses).associateWith { mutableListOf<Int>() }
        for ((a, b) in prerequisites) {
            deps[a]!!.add(b)
        }

        val res = IntArray(numCourses)
        var index = 0
        val visited = BooleanArray(numCourses)
        val tempVisited = BooleanArray(numCourses)

        fun trace(node: Int): Boolean {
            if (visited[node]) return true
            if (tempVisited[node]) return false

            tempVisited[node] = true

            for (c in deps[node]!!) {
                if (!trace(c)) {
                    return false
                }
            }

            visited[node] = true
            res[index] = node
            index++

            return true
        }

        for (k in deps.keys) {
            if (!trace(k)) return intArrayOf()
        }

        return res
    }
}
