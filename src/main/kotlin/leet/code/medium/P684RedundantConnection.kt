package leet.code.medium

import leet.code.Solution

class P684RedundantConnection : Solution {

    override fun test() {

    }

    class DisjointSet(val n: Int) {
        private val parent = IntArray(n) { it }
        private val rank = IntArray(n)

        fun find(i: Int): Int {
            if (parent[i] == i) {
                return i
            }
            parent[i] = find(parent[i])
            return parent[i]
        }

        fun union(i: Int, j: Int): Boolean {
            val left = find(i)
            val right = find(j)
            if (left == right) return false

            if (rank[left] < rank[right]) {
                parent[left] = right
            } else if (rank[left] > rank[right]) {
                parent[right] = left
            } else {
                parent[right] = left
                rank[left]++
            }
            return true
        }
    }

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val ds = DisjointSet(edges.size + 1)
        return edges.firstOrNull { !ds.union(it[0], it[1]) } ?: intArrayOf()
    }
}
