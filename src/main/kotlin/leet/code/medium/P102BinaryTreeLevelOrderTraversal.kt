package leet.code.medium

import leet.code.Solution
import leet.code.util.TreeNode

class P102BinaryTreeLevelOrderTraversal : Solution {

    override fun test() {

    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val levels = mutableListOf<MutableList<Int>>()
        val queue = mutableListOf(Pair(root, 0))
        var curr = 0
        var level = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val (node, num) = queue.removeFirst()
            node.left?.let { queue.add(Pair(it, num + 1)) }
            node.right?.let { queue.add(Pair(it, num + 1)) }
            if (num == curr) {
                level.add(node.`val`)
                continue
            }

            levels.add(level)
            level = mutableListOf(node.`val`)
            curr = num
        }
        levels.add(level)

        return levels
    }
}