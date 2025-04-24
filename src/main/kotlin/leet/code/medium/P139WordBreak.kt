package leet.code.medium

import leet.code.Solution


class P139WordBreak : Solution {

    override fun test() {
        println(
            wordBreak(
                "catsandog",
                listOf("cats", "dog", "sand", "and", "cat")
            )
        )
    }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val validPrefix = BooleanArray(s.length + 1)
        validPrefix[0] = true

        for (i in 1..s.length) {
            for (w in wordDict) {
                val start = i - w.length
                if (start >= 0 && validPrefix[start] && s.substring(start, i) == w) {
                    validPrefix[i] = true
                    break
                }
            }
        }

        return validPrefix[s.length]
    }

//    fun wordBreak(s: String, wordDict: List<String>): Boolean {
//        val set = mutableSetOf<String>()
//
//        fun helper(newS: String): Boolean {
//            if (newS.length > s.length || set.contains(newS) || s.substring(0, newS.length) != newS) {
//                return false
//            }
//
//            if (s == newS) return true
//
//            var ans = false
//            for (word in wordDict) {
//                ans = ans || helper(newS + word)
//            }
//
//            if (!ans) set.add(newS)
//
//            return ans
//        }
//
//        return helper("")
//    }
}
