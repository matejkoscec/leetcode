package leet.code.medium

import leet.code.Solution
import leet.code.util.Node

class P133CloneGraph : Solution {

    override fun test() {
        val n1 = Node(1)
        val n2 = Node(2)
        val n3 = Node(3)
        val n4 = Node(4)
        n1.neighbors.addAll(listOf(n2, n4))
        n2.neighbors.addAll(listOf(n1, n3))
        n3.neighbors.addAll(listOf(n2, n4))
        n4.neighbors.addAll(listOf(n1, n3))
        println(cloneGraph(n1)?.neighbors)
    }

    val map = mutableMapOf<Int, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }

        var newNode = map[node.`val`]
        if (newNode != null) {
            return newNode
        }
        newNode = Node(node.`val`)
        map[newNode.`val`] = newNode
        for (n in node.neighbors) {
            newNode.neighbors.add(cloneGraph(n))
        }

        return newNode
    }
}