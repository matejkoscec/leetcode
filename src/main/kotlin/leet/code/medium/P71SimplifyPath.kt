package leet.code.medium

import leet.code.Solution

object P71SimplifyPath : Solution {

    override fun test() {
        println(simplifyPath("/home/"))
        println(simplifyPath("/../"))
        println(simplifyPath("/home//foo/"))
        println(simplifyPath("/a//b////c/d//././/.."))
    }

    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()

        var buffer = StringBuilder()
        for (c in "$path/") {
            if (c != '/') {
                buffer.append(c)
                continue
            }

            when (val str = buffer.toString()) {
                "" -> {}
                "." -> {}
                ".." -> if (stack.isNotEmpty()) stack.removeAt(stack.lastIndex)
                else -> stack.add(str)
            }
            buffer = StringBuilder()
        }

        return if (stack.isEmpty())
            "/"
        else
            stack.fold(StringBuilder()) { acc, s -> acc.append('/').append(s) }.toString()
    }
}
