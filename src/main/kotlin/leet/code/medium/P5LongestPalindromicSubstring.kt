package leet.code.medium

import leet.code.Solution
import kotlin.math.max

class P5LongestPalindromicSubstring : Solution {

    override fun test() {
        println(longestPalindrome("babad"))
    }

    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""

        var start = 0
        var end = 0
        for (i in s.indices) {
            val len1 = palindromic(s, i, i)
            val len2 = palindromic(s, i, i + 1)
            val len = max(len1, len2)
            if (len > end - start) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }

        return s.substring(start, end + 1)
    }

    private fun palindromic(s: String, l: Int, r: Int): Int {
        var left = l
        var right = r
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }

        return right - left - 1
    }
}