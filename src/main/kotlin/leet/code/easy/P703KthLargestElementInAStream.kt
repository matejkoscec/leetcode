package leet.code.easy

import leet.code.Solution
import java.util.*

class P703KthLargestElementInAStream : Solution {

    override fun test() {
        val kthLargest = KthLargest(3, intArrayOf(4, 5, 8, 2));
        println(kthLargest.add(3));
        println(kthLargest.add(5));
        println(kthLargest.add(10));
        println(kthLargest.add(9));
        println(kthLargest.add(4));
    }

    class KthLargest(val k: Int, nums: IntArray) {

        val minHeap = PriorityQueue<Int>()

        init {
            for (num in nums) {
                if (minHeap.size < k) {
                    minHeap.add(num)
                } else if (num > minHeap.peek()) {
                    minHeap.add(num)
                    if (minHeap.size > k) {
                        minHeap.poll()
                    }
                }
            }
        }

        fun add(`val`: Int): Int {
            if (minHeap.size < k) {
                minHeap.add(`val`)
            } else if (`val` > minHeap.peek()) {
                minHeap.add(`val`)
                minHeap.poll()
            }
            return minHeap.peek()
        }
    }
}
