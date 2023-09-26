package leet.code.medium

import leet.code.Solution

class P6ZigZagConversion : Solution {

    override fun test() {
        println(convert("PAYPALISHIRING", 4))
    }

    // With pretty print
//    fun convert(s: String, numRows: Int): String {
//        if (numRows == 1) {
//            return s
//        }
//
//        val sb = StringBuilder()
//        for (slidingWindow in 0..<numRows) {
//            var i = slidingWindow
//            while (i < s.length) {
//                sb.append(s[i])
//                for (j in 0..<numRows - 2 - slidingWindow) {
//                    sb.append(' ')
//                }
//                if (slidingWindow in 1..<numRows - 1 && i + 2 * (numRows - 1 - slidingWindow) < s.length) {
//                    sb.append(s[i + 2 * (numRows - 1 - slidingWindow)])
//                }
//                for (j in numRows - 1 - slidingWindow..<numRows - 2) {
//                    sb.append(' ')
//                }
//                i += (numRows - 1) * 2
//            }
//            sb.append('\n')
//        }
//
//        return sb.toString()
//    }

    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        val sb = StringBuilder()
        for (slidingWindow in 0..<numRows) {
            var i = slidingWindow
            while (i < s.length) {
                sb.append(s[i])
                val diagonalIndex = i + 2 * (numRows - 1 - slidingWindow)
                if (slidingWindow in 1..<numRows - 1 && diagonalIndex < s.length) {
                    sb.append(s[diagonalIndex])
                }
                i += (numRows - 1) * 2
            }
        }

        return sb.toString()
    }
}
