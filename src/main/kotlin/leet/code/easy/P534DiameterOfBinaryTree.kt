package leet.code.easy

import leet.code.Solution
import leet.code.util.TreeNode
import leet.code.util.tnode
import kotlin.math.max

class P534DiameterOfBinaryTree : Solution {

    override fun test() {
        val root = tnode(1) {
            left = tnode(2) {
                left = tnode(4)
                right = tnode(5)
            }
            right = tnode(3)
        }
        diameterOfBinaryTree(root).also { println(it) }
    }

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var m = 0

        fun trace(node: TreeNode?): Int {
            if (node == null) return 0
            val left = trace(node.left)
            val right = trace(node.right)
            m = max(m, left + right)
            return max(left, right) + 1
        }

        trace(root)

        return m
    }
}