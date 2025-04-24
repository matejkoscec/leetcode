package leet.code.medium

import leet.code.Solution
import java.util.PriorityQueue

class P215KthLargestElementInAnArray : Solution {

    override fun test() {

    }

    fun findKthLargest(nums: IntArray, k: Int): Int {
        val q = PriorityQueue<Int>(compareByDescending { it })
        for (num in nums) q.add(num)
        var i = 0
        var res = 0
        while (i < k) {
            res = q.poll()
            i++
        }
        return res
    }
}
