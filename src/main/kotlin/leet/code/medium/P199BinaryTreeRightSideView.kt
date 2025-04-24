package leet.code.medium

import leet.code.Solution
import leet.code.util.TreeNode

class P199BinaryTreeRightSideView : Solution {

    override fun test() {

    }

    fun rightSideView(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        var globalLevel = 0

        fun trace(node: TreeNode?, level: Int) {
            if (node == null) return

            if (level == globalLevel) {
                res.add(node.`val`)
                globalLevel++
            }

            trace(node.right, level + 1)
            trace(node.left, level + 1)
        }

        trace(root, 0)

        return res
    }
}
