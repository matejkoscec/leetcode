package leet.code.medium

import leet.code.Solution

class P438FindAllAnagramsInAString : Solution {

    override fun test() {

    }

    fun findAnagrams(s: String, p: String): List<Int> {
        val letters = p.groupingBy { it }.eachCount()

        val indices = mutableListOf<Int>()
        for (i in s.indices) {
            if (s[i] !in letters) continue

            val currentCounts = mutableMapOf<Char, Int>()
            var j = i
            while (j < s.length && j < i + p.length && s[j] in letters) {
                currentCounts[s[j]] = (currentCounts[s[j]] ?: 0) + 1
                j++
            }
            if (currentCounts == letters) {
                indices.add(i)
            }
        }

        return indices
    }
}
