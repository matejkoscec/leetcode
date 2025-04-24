package leet.code.medium

import leet.code.Solution
import leet.code.util.TreeNode

class P235LowestCommonAncestor : Solution {

    override fun test() {

    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var node = root
        while (node != null) {
            if (p!!.`val` > node.`val` && q!!.`val` > node.`val`) {
                node = node.right
            } else if (p!!.`val` < node.`val` && q!!.`val` < node.`val`) {
                node = node.left
            } else {
                return node
            }
        }

        return null
    }
}
