package leet.code.easy

import leet.code.Solution

class P58LengthOfLastWord : Solution {

    override fun test() {
        println(lengthOfLastWord("   fly me   to   the moon  "))
    }

    // First solution
//    fun lengthOfLastWord(s: String): Int {
//        var len = 0
//        var lastLetterIndex = s.length - 1
//        while (lastLetterIndex >= 0 && !s[lastLetterIndex].isLetter()) {
//            lastLetterIndex--
//        }
//        while (lastLetterIndex >= 0 && s[lastLetterIndex].isLetter()) {
//            lastLetterIndex--
//            len++
//        }
//
//        return len
//    }

    fun lengthOfLastWord(s: String): Int {
        var len = 0
        var foundWord = false
        for (i in s.indices.reversed()) {
            if (!s[i].isWhitespace()) {
                len++
                foundWord = true
                continue
            }
            if (foundWord) {
                break
            }
        }

        return len
    }
}
