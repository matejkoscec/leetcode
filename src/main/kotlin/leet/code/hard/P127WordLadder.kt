package leet.code.hard

import leet.code.Solution
import java.util.*
import kotlin.math.abs


class P127WordLadder : Solution {

    override fun test() {
        println(
            ladderLength(
                "hit",
                "cog",
                listOf("hot", "dot", "dog", "lot", "log", "cog")
            )
        )
        println(
            ladderLength(
                "leet",
                "code",
                listOf("lest", "leet", "lose", "code", "lode", "robe", "lost")
            )
        )
    }

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = wordList.toMutableSet()
        if (endWord !in wordSet) {
            return 0
        }
        wordSet.add(beginWord)

        fun diffCount(a: String, b: String): Int {
            var diffs = 0
            for (i in a.indices) {
                if (a[i] != b[i]) diffs++
                if (diffs > 1) break
            }
            return diffs
        }

        val queue = ArrayDeque<Pair<String, Int>>()
        queue.add(Pair(beginWord, 1))
        val visited = mutableSetOf(beginWord)
        while (queue.isNotEmpty()) {
            val (word, transforms) = queue.removeFirst()
            if (word == endWord) {
                return transforms
            }
            for (w in wordSet) {
                if (w !in visited && diffCount(word, w) == 1) {
                    queue.add(Pair(w, transforms + 1))
                    visited.add(w)
                }
            }
        }

        return 0
    }
}
