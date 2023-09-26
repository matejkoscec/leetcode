package leet.code.easy

import leet.code.Solution

class P108ConvertSortedArrayToBinarySearchTree : Solution {

    override fun test() {
        val nums = intArrayOf(-10, -3, 0, 5, 9)
        val root = sortedArrayToBST(nums)
        println(root)
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return null
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        override fun toString(): String {
            return "$`val`($left, $right)"
        }
    }
}
