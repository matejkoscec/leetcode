package leet.code.easy

import leet.code.Solution

class P844BackspaceStringCompare : Solution {

    override fun test() {
        println(backspaceCompare(s = "ab#c", t = "ad#c"))
        println(backspaceCompare(s = "ab##", t = "c#d#"))
        println(backspaceCompare(s = "a#c", t = "b"))
    }

    fun backspaceCompare(s: String, t: String): Boolean {
        val ss = StringBuilder(s.length)
        val st = StringBuilder(t.length)

        for (char in s) {
            if (char == '#') {
                if (ss.isNotEmpty()) {
                    ss.deleteCharAt(ss.length - 1)
                }
            } else {
                ss.append(char)
            }
        }
        for (char in t) {
            if (char == '#') {
                if (st.isNotEmpty()) {
                    st.deleteCharAt(st.length - 1)
                }
            } else {
                st.append(char)
            }
        }

        return ss.toString() == st.toString()
    }
}
