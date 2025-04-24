package leet.code.easy

import leet.code.Solution
import leet.code.util.TreeNode

class P572SubtreeOfAnotherTree : Solution {

    override fun test() {

    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return subRoot == null
        return traceSubTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun traceSubTree(node: TreeNode?, subNode: TreeNode?): Boolean {
        if (node == null && subNode == null) return true;
        if (node == null || subNode == null) return false
        if (node.`val` != subNode.`val`) return false
        return traceSubTree(node.left, subNode.left) && traceSubTree(node.right, subNode.right)
    }
}
