package leet.code.medium

import leet.code.Solution

class P49GroupAnagrams : Solution {

    override fun test() {
        println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { it.sorted() }.values.toList()
    }

    private fun String.sorted(): String {
        val arr = toCharArray()
        arr.sort()
        return arr.joinToString("")
    }
}
