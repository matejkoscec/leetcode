package leet.code.hard

import leet.code.Solution

class P44WildcardMatching : Solution {

    override fun test() {
        println(isMatch("cb", "?a"))
    }

    fun isMatch(s: String, p: String): Boolean {
        var sIdx = 0;
        var pIdx = 0;

        var pStar = -1;
        var sStarPos = -1;
        while (sIdx < s.length) {
            if (pIdx < p.length && (p[pIdx] == '?' || (p[pIdx] in 'a'..'z' && s[sIdx] == p[pIdx]))) {
                sIdx++;
                pIdx++;
                continue
            }

            if (pIdx < p.length && p[pIdx] == '*') {
                pStar = pIdx++
                sStarPos = sIdx
                continue
            }

            if (pStar > -1) {
                pIdx = pStar + 1
                sStarPos++
                sIdx = sStarPos
                continue
            }

            return false
        }

        while (pIdx < p.length) {
            if (p[pIdx] == '*') {
                pIdx++
            } else {
                return false
            }
        }


        return pIdx == p.length && sIdx == s.length
    }

    // Recursive memo
//    fun isMatch(s: String, p: String): Boolean {
//        val memo = mutableMapOf<Pair<Int, Int>, Boolean>()
//
//        fun trace(i: Int, j: Int): Boolean {
//            val ij = Pair(i, j)
//            if (ij in memo) {
//                return memo[ij]!!
//            }
//
//            memo[ij] = when {
//                i >= s.length && j >= p.length -> {
//                    true
//                }
//
//                j >= p.length -> {
//                    false
//                }
//
//                i >= s.length -> {
//                    if (p[j] == '*') trace(i, j + 1) else false
//                }
//
//                p[j] == '*' -> {
//                    trace(i + 1, j + 1) || trace(i, j + 1) || trace(i + 1, j)
//                }
//
//                p[j] == '?' || p[j] == s[i] -> {
//                    trace(i + 1, j + 1)
//                }
//
//                else -> {
//                    false
//                }
//            }
//
//            return memo[ij]!!
//        }
//
//        return trace(0, 0)
//    }
}
