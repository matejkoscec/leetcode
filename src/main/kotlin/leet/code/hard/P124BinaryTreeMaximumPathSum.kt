package leet.code.hard

import leet.code.Solution
import leet.code.util.TreeNode
import leet.code.util.tnode
import kotlin.math.max

class P124BinaryTreeMaximumPathSum : Solution {

    override fun test() {
        val root = tnode(-10) {
            left = tnode(9)
            right = tnode(20) {
                left = tnode(15)
                right = tnode(7)
            }
        }
        println(maxPathSum(root))
    }

    private var max = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        trace(root)
        return max
    }

    private fun trace(node: TreeNode?): Int {
        if (node == null) return 0

        val left = max(trace(node.left), 0)
        val right = max(trace(node.right), 0)

        val currentMax = node.`val` + left + right
        max = max(max, currentMax)

        return node.`val` + max(left, right)
    }
}