package leet.code.hard

import leet.code.Solution

class P664StrangePrinter : Solution {

    override fun test() {
        println(strangePrinter("abcabcabc"))
    }

    // Nuh-uh

    // aaaaaaaaa - abbbbbbba - abccccccc - abcaaaacc - abcabbbbc - abcabcbbc - abcabcabc
    fun strangePrinter(s: String): Int {
        if (s.length == 1) return 1

        val sb = StringBuilder()
        repeat(s.length) { sb.append(s[0]) }
        var count = 1
        var i = 0
        while (i < s.length) {
            val c = s[i]
            if (sb[i] == c) {
                i++
                continue
            }
            for (j in i..s.lastIndexOf(c)) {
                sb[j] = c
            }
            count++
            println(sb.toString())
            i++
        }

        return count
    }
}