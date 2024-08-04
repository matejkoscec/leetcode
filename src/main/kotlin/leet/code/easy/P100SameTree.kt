package leet.code.easy

import leet.code.Solution
import leet.code.util.TreeNode

object P100SameTree : Solution {

    override fun test() {
        println(
            isSameTree(
                p = TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(1)
                },
                q = TreeNode(1).apply {
                    left = TreeNode(1)
                    right = TreeNode(2)
                }
            )
        )
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean = when {
        p == null || q == null -> q == p
        else -> p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}
