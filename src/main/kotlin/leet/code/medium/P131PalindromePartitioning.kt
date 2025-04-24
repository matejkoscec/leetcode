package leet.code.medium

import leet.code.Solution


class P131PalindromePartitioning : Solution {

    override fun test() {
        println(partition("aab"))
    }

    // backtracking + memo
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val dp = Array(s.length) { BooleanArray(s.length) }

        fun backtrack(start: Int, path: MutableList<String>) {
            if (start == s.length) {
                res.add(ArrayList<String>(path))
                return
            }
            for (end in start..<s.length) {
                if (dp[start][end]) {
                    path.add(s.substring(start, end + 1))
                    backtrack(end + 1, path)
                    path.removeAt(path.size - 1)
                }
            }
        }

        for (i in 0..<s.length) {
            dp[i][i] = true
        }
        for (length in 2..s.length) {
            for (i in 0..s.length - length) {
                val j = i + length - 1
                if (s[i] == s[j] && (length == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true
                }
            }
        }

        backtrack(0, mutableListOf())

        return res
    }

    // backtracking
//    fun partition(s: String): List<List<String>> {
//        val res = mutableListOf<List<String>>()
//
//        fun trace(i: Int, path: MutableList<String>) {
//            if (i == s.length) {
//                res.add(path.toList())
//                return
//            }
//            for (j in i + 1..s.length) {
//                if (!isPalindrome(s, i, j - 1)) continue
//                path.add(s.substring(i, j))
//                trace(j, path)
//                path.removeAt(path.size - 1)
//            }
//        }
//
//        trace(0, mutableListOf())
//
//        return res
//    }
//
//    private fun isPalindrome(s: String, left: Int, right: Int): Boolean {
//        var left = left
//        var right = right
//        while (left < right) {
//            if (s[left++] != s[right--]) {
//                return false
//            }
//        }
//        return true
//    }
}
