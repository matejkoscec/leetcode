package leet.code.medium

import leet.code.Solution
import leet.code.util.strArraysToList

class P802FindEventualSafeStates : Solution {

    override fun test() {
        val ex1 = strArraysToList("[[1,2],[2,3],[5],[0],[5],[],[]]") { it.toIntArray() }.toTypedArray()
        val ex2 = strArraysToList("[[1,2,3,4],[1,2],[3,4],[0,4],[]]") { it.toIntArray() }.toTypedArray()
        println(eventualSafeNodes(ex1))
        println(eventualSafeNodes(ex2))
    }

    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val visited = IntArray(graph.size)
        return graph.indices.filter { trace(graph, it, visited) }
    }

    fun trace(graph: Array<IntArray>, node: Int, visited: IntArray): Boolean {
        if (visited[node] == 1) return false
        if (visited[node] == 2) return true

        visited[node] = 1
        for (n in graph[node]) {
            if (!trace(graph, n, visited)) {
                return false
            }
        }
        visited[node] = 2

        return true
    }

    // Too slow
//    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
//        return graph.indices.filter { trace(graph, it, setOf()) }
//    }
//
//    private fun trace(graph: Array<IntArray>, node: Int, visited: Set<Int>): Boolean {
//        if (node in visited) return false
//        if (graph[node].isEmpty()) return true
//        return graph[node].all { trace(graph, it, visited + node) }
//    }
}