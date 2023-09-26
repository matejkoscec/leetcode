package leet.code.medium

import leet.code.Solution

class P3LongestSubstringWithoutRepeatingChars : Solution {

    override fun test() {
        println(lengthOfLongestSubstring("pwwkew"))
    }

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) {
            return s.length
        }

        var max = 1
        var pBehind = 0
        for (i in 1..<s.length) {
            val c = s[i]
            if (!inWindow(s, c, pBehind, i)) {
                continue
            }

            val len = i - pBehind
            if (len > max) {
                max = len
            }

            var passed = false
            while (!passed) {
                if (s[pBehind++] == c) {
                    passed = true
                }
            }
        }
        val len = s.length - pBehind
        if (len > max) {
            max = len
        }

        return max
    }

    private fun inWindow(window: String, c: Char, lower: Int, upper: Int): Boolean {
        return (lower..<upper).any { i -> window[i] == c }
    }

    // Faster than brute force
//    fun lengthOfLongestSubstring(s: String): Int {
//        if (s.length <= 1) {
//            return s.length
//        }
//
//        var max = 1
//        val window = HashSet<Char>()
//        window.add(s[0])
//        var pBehind = 0
//        for (i in 1 until s.length) {
//            val c = s[i]
//            if (c !in window) {
//                window.add(c)
//            } else {
//                val len = i - pBehind
//                if (len > max) {
//                    max = len
//                }
//
//                var passed = false
//                while (!passed) {
//                    val tChar = s[pBehind++]
//                    if (tChar == c) {
//                        passed = true
//                    } else {
//                        window.remove(tChar)
//                    }
//                }
//            }
//        }
//        if (window.size > max) {
//            max = window.size
//        }
//
//        return max
//    }

    // Brute force, too slow
//    fun lengthOfLongestSubstring(s: String): Int {
//        if (s.length <= 1) {
//            return s.length
//        }
//
//        val chars = HashSet<Char>()
//
//        var max = 1
//        var len = 1
//        var slidingWindow = 0
//        while (slidingWindow < s.length) {
//            chars.add(s[slidingWindow])
//
//            for (i in slidingWindow + 1 until s.length) {
//                val c = s[i]
//                if (c in chars) {
//                    if (len > max) {
//                        max = len
//                    }
//                    chars.clear()
//                    chars.add(c)
//                    len = 1
//                } else {
//                    chars.add(c)
//                    len++
//                }
//            }
//            if (len > max) {
//                max = len
//            }
//
//            chars.clear()
//            slidingWindow++
//            len = 1
//        }
//
//        return max
//    }
}
