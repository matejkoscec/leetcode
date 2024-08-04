package leet.code.easy

import leet.code.Solution

class P242ValidAnagram : Solution {

    override fun test() {
        println(isAnagram("anagram", "nagaram"))
    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val a = s.groupingBy { it }.eachCount()
        val b = t.groupingBy { it }.eachCount()
        return a.all { (k, v) -> v == b[k] }
    }
}
