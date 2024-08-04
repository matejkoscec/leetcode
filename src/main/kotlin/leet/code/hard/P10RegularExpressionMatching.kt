package leet.code.hard

import leet.code.Solution

class P10RegularExpressionMatching : Solution {

    override fun test() {
        println(isMatch("abc", "a.*c"))
    }

    enum class Type { REGULAR, DOT, STAR, START }

    class State(
        val type: Type,
        val char: Char,
        val transitions: HashMap<Char, State> = HashMap(),
        var final: Boolean = false
    ) {
        override fun toString(): String {
            return "S($type, $char, $transitions, $final)"
        }
    }

    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) {
            return true
        }
        if ('*' !in p && '.' !in p) {
            return s == p
        }

        val list = ArrayList<State>()
        list.add(State(Type.START, '-'))
        for (char in p) {
            val state = when (char) {
                '*' -> State(Type.STAR, char)
                '.' -> State(Type.DOT, char)
                else -> State(Type.REGULAR, char)
            }
            list.add(state)
        }

        var currentState = list[0]
        for (i in 1..<list.size) {
            val state = list[i]
            val prevState = list[i - 1]
            if (i == list.size - 1) {
                state.final = true
            }

            when (state.type) {
                Type.REGULAR -> {
                    prevState.transitions[state.char] = state
                }

                Type.DOT -> {
                    prevState.transitions[state.char] = state
                }

                Type.STAR -> {
                    currentState.transitions[state.char] = state
                    if (i < list.size - 1) {
                        currentState = state
                    }
                }

                Type.START -> {
                    continue
                }
            }
        }

        currentState = list[0]
        var i = 0
        while (i < s.length) {
            var state = list[0]
            var j = 0
            while (j < p.length && j + i < s.length) {
                val char = s[j + i]
                val tChar = p[j]
                if (tChar == '*') {
                    state = currentState
                    currentState = currentState.transitions['*'] ?: break
                    i--
                } else if (tChar == '.') {
                    state = state.transitions['.'] ?: break
                } else {
                    state = state.transitions[char] ?: currentState.transitions[char] ?: break
                }
                j++
            }
            if (state.final) {
                return true
            }
            i++
        }

        return false
    }

//    fun isMatch(s: String, p: String): Boolean {
//        if (p.isEmpty() || p.endsWith("*")) {
//            return true
//        }
//        if ('*' !in p && '.' !in p) {
//            return s == p
//        }
//
//        val sb = StringBuilder()
//        for (char in p.reversed()) {
//            if (char == '*') {
//                break
//            } else {
//                sb.insert(0, char)
//            }
//        }
//        val pattern = sb.toString()
//
//        for (i in s.indices) {
//            var matches = true
//            for (j in pattern.indices) {
//                if (s[i + j] != pattern[j] && pattern[j] != '.') {
//                    matches = false
//                    break
//                }
//            }
//            if (matches) {
//                return true
//            }
//        }
//
//        return false
//    }
}
