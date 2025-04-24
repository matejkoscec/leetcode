package leet.code.medium

import leet.code.Solution
import leet.code.util.TreeNode
import kotlin.math.max

class P1448CountGoodNodesInBinaryTree : Solution {

    override fun test() {

    }

    fun goodNodes(root: TreeNode?): Int {
        var res = 0

        fun trace(node: TreeNode?, maxVal: Int) {
            if (node == null) return

            if (node.`val` >= maxVal) {
                res++
            }

            val currMax = max(node.`val`, maxVal)
            trace(node.left, currMax)
            trace(node.right, currMax)
        }

        trace(root, root?.`val` ?: 0)

        return res
    }
}
