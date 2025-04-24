package leet.code.medium

import leet.code.Solution
import leet.code.util.TreeNode
import java.util.PriorityQueue
import java.util.TreeMap

class P105ConstructBinaryTreeFromPreorderAndInorderTraversal : Solution {

    override fun test() {

    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val map = inorder.withIndex().associate { it.value to it.index }
        val pre = preorder.toMutableList()

        fun trace(start: Int, end: Int): TreeNode? {
            if (start > end) return null

            val node = TreeNode(pre.removeFirst())
            val mid = map[node.`val`]!!

            node.left = trace(start, mid - 1)
            node.right = trace(mid + 1, end)

            return node
        }

        return trace(0, preorder.lastIndex)
    }
}
