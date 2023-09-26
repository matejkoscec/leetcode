package leet.code.medium

import leet.code.Solution
import leet.code.util.toIntArray
import java.util.*

class P31NextPermutation : Solution {

    override fun test() {
        println(5.`!`)
        val arr = (1..4).toIntArray()
        arr.dumpAllPermutations()
        println()

        val nums = intArrayOf(4, 3, 2, 1)
        nextPermutation(nums)
        println(nums.contentToString())
    }

    fun nextPermutation(nums: IntArray) {
        if (nums.size <= 1) {
            return
        }

        var left = nums.size - 2
        var right = nums.size - 1
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--
        }

        if (left >= 0) {
            while (nums[right] <= nums[left]) right--
            nums.swap(left, right)
        }

        reverse(nums, left + 1, nums.size - 1)
    }

    private fun IntArray.swap(i: Int, j: Int) {
        this[i] = this[j].also { this[j] = this[i] }
    }

    private fun reverse(nums: IntArray, p1: Int, p2: Int) {
        var i = p1
        var j = p2
        while (i < j) {
            nums.swap(i++, j--)
        }
    }

    val Int.`!` get() = (1..this).reduce { acc, i -> acc * i }

    private fun IntArray.dumpAllPermutations() {
        val out = mutableListOf<String>()
        permute(this.toList(), 0, out)
        out.sortBy { it }
        out.forEach(::println)
    }

    private fun permute(arr: List<Int>, k: Int, out: MutableList<String>) {
        for (i in k..<arr.size) {
            Collections.swap(arr, i, k)
            permute(arr, k + 1, out)
            Collections.swap(arr, k, i)
        }
        if (k == arr.size - 1) {
            out.add(arr.toTypedArray().contentToString())
        }
    }
}
