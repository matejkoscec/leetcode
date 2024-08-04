package leet.code.easy

import leet.code.Solution

class P28FindIndexOfFirstOccurrence : Solution {

    override fun test() {
        println(strStr("sadbutsad", "sad"))
    }

    // Lazy solution
//    fun strStr(haystack: String, needle: String): Int {
//        return needle.toRegex().find(haystack)?.range?.first ?: -1
//    }

    // Faster solution
//    fun strStr(haystack: String, needle: String): Int {
//        for (i in haystack.indices) {
//            if (haystack[i] != needle[0]) {
//                continue
//            }
//
//            var len = 0
//            var j = 0
//            var k = i
//            while (k < haystack.length && j < needle.length) {
//                if (haystack[k++] == needle[j++]) {
//                    len++
//                }
//            }
//            if (len == needle.length) {
//                return i
//            }
//        }
//
//        return -1
//    }

    // Fastest solution
    fun strStr(haystack: String, needle: String): Int {
        var len = 0
        var i = 0
        while (i < haystack.length) {
            len = if (haystack[i] == needle[len]) {
                len + 1
            } else {
                i -= len
                0
            }
            if (len == needle.length) {
                return i - len + 1
            }
            i++
        }

        return -1
    }
}
