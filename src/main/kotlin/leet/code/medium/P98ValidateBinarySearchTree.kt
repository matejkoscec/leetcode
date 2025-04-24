package leet.code.medium

import leet.code.Solution
import leet.code.util.TreeNode
import leet.code.util.tnode

class P98ValidateBinarySearchTree : Solution {

    override fun test() {
        println(
            isValidBST(
                tnode(5) {
                    left = tnode(4)
                    right = tnode(6) {
                        left = tnode(3)
                        right = tnode(7)
                    }
                }
            )
        )
    }

    fun isValidBST(root: TreeNode?): Boolean {
        fun trace(node: TreeNode?, minimum: Long, maximum: Long): Boolean {
            if (node == null) return true
            if (node.`val` !in (minimum + 1)..<maximum) return false
            return trace(node.left, minimum, node.`val`.toLong()) && trace(node.right, node.`val`.toLong(), maximum)
        }

        return trace(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}
