package leet.code.medium

import leet.code.Solution
import kotlin.text.StringBuilder

object P17LetterCombinationsOfAPhoneNumber : Solution {

    override fun test() {
        println(letterCombinations("23"))
    }

    private val mappings = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return listOf()
        }

        val combinations = mutableListOf<String>()
        track(combinations, digits, StringBuilder())

        return combinations
    }

    fun track(combinations: MutableList<String>, digits: String, prefix: StringBuilder) {
        if (digits.isEmpty()) {
            return
        }

        val digit = digits[0]
        for (char in mappings[digit - '0' - 2]) {
            if (digits.length == 1) {
                combinations.add(prefix.append(char).toString())
                prefix.deleteCharAt(prefix.length - 1)
                continue
            }
            track(combinations, digits.drop(1), prefix.append(char))
            prefix.deleteCharAt(prefix.length - 1)
        }
    }
}
