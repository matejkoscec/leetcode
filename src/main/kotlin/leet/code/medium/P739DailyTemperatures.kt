package leet.code.medium

import leet.code.Solution

class P739DailyTemperatures : Solution {

    override fun test() {
        println(dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).contentToString())
    }

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size)

        var max = 0
        for (i in answer.lastIndex downTo 0) {
            val temp = temperatures[i]
            if (temp >= max) {
                max = temp
                continue
            }

            var days = 1
            while (temperatures[i + days] <= temp) {
                days += answer[i + days]
            }
            answer[i] = days
        }

        return answer
    }

    // First solution
//    fun dailyTemperatures(temperatures: IntArray): IntArray {
//        val answer = IntArray(temperatures.size)
//
//        for (i in answer.indices) {
//            val temp = temperatures[i]
//
//            var days = 0
//            var found = false
//            for (j in i..answer.lastIndex) {
//                if (temp < temperatures[j]) {
//                    found = true
//                    break
//                }
//                days++
//            }
//
//            if (found) {
//                answer[i] = days
//            }
//        }
//
//        return answer
//    }
}
