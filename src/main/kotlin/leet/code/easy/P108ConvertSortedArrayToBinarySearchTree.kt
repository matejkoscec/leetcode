package leet.code.easy

import leet.code.Solution
import leet.code.util.TreeNode

// TODO
class P108ConvertSortedArrayToBinarySearchTree : Solution {

    override fun test() {
        val nums = intArrayOf(-10, -3, 0, 5, 9)
        val root = sortedArrayToBST(nums)
        println(root)
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return null
    }
}
