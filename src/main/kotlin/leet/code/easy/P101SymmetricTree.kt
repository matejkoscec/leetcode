package leet.code.easy

import leet.code.Solution
import leet.code.util.TreeNode

class P101SymmetricTree : Solution {

    override fun test() {

    }

    fun isSymmetric(root: TreeNode?): Boolean {
        return trace(root?.left, root?.right)
    }

    fun trace(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }
        if (left?.`val` != right?.`val`) {
            return false
        }

        return trace(left?.left, right?.right) && trace(left?.right, right?.left)
    }
}