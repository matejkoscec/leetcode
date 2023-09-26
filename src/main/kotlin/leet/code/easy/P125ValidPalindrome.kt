package leet.code.easy

import leet.code.Solution

class P125ValidPalindrome : Solution {

    override fun test() {
        println(isPalindrome("anna"))
    }

    // Initial solution
//    fun isPalindrome(s: String): Boolean {
//        val stack = ArrayDeque<Char>()
//        val sb = StringBuilder()
//
//        for (char in s) {
//            if (char.isLetterOrDigit()) {
//                sb.append(char.lowercaseChar())
//            }
//        }
//        val str = sb.toString()
//        if (str.length == 1) {
//            return true
//        }
//        val middle = str.length / 2
//        for (i in 0 until middle) {
//            stack.addFirst(str[i])
//        }
//        for (i in middle until str.length) {
//            if (stack.isEmpty()) {
//                return false
//            }
//            if (stack.first() == str[i]) {
//                stack.removeFirst()
//            }
//        }
//
//        return stack.isEmpty()
//    }

    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.length - 1

        while (start <= end) {
            if (!s[start].isLetterOrDigit()) {
                start++
                continue
            }
            if (!s[end].isLetterOrDigit()) {
                end--
                continue
            }
            if (s[start].lowercaseChar() != s[end].lowercaseChar()) {
                return false
            } else {
                start++
                end--
            }
        }

        return true
    }
}
