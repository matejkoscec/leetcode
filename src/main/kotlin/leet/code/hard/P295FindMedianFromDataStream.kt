package leet.code.hard

import leet.code.Solution
import java.util.PriorityQueue
import kotlin.math.abs

class P295FindMedianFromDataStream : Solution {

    override fun test() {
        
    }

    class MedianFinder() {

        val lower = PriorityQueue<Int>(compareByDescending { it })
        val higher = PriorityQueue<Int>()

        fun addNum(num: Int) {
            if (length() == 0 || num < lower.peek()) {
                lower.add(num)
            } else {
                higher.add(num)
            }

            val rangeLengthDiff = length() % 2
            while (abs(lower.size - higher.size) > rangeLengthDiff) {
                if (lower.size > higher.size) {
                    higher.add(lower.poll())
                } else {
                    lower.add(higher.poll())
                }
            }
        }

        fun findMedian(): Double {
            val isEvenLength = length() % 2 == 0
            if (isEvenLength) {
                return (lower.peek() + higher.peek()) / 2.0
            }
            val range = if (lower.size > higher.size) lower else higher
            return range.peek().toDouble()
        }

        private fun length(): Int = lower.size + higher.size
    }
}
