package leet.code.hard

import leet.code.Solution

class P65ValidNumber : Solution {

    override fun test() {
        arrayOf("abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53")
            .forEach { println("$it: ${isNumber(it)}") }
        arrayOf("2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789")
            .forEach { println("$it: ${isNumber(it)}") }
        println(isNumber("+."))
    }

    fun isNumber(s: String): Boolean {
        var num = false
        var exp = false
        var dot = false

        for ((i, c) in s.withIndex()) when {
            c.isDigit() -> {
                num = true
            }
            c == 'e' || c == 'E' -> {
                if (exp || !num) return false
                exp = true
                num = false
            }
            c == '.' -> {
                if (dot || exp) return false
                dot = true
            }
            c == '-' || c == '+' -> {
                if (i != 0 && s[i - 1] != 'e' && s[i - 1] != 'E') return false
            }
            else -> {
                return false
            }
        }

        return num
    }

    // Close
//    private sealed interface NumberType
//    private data class Integer : NumberType
//    private data class Decimal(
//        var hasDecimal: Boolean = false,
//        var isSciNotation: Boolean = false,
//        var isSciSigned: Boolean = false
//    ) : NumberType
//
//    fun isNumber(s: String): Boolean {
//        val last = s[s.lastIndex]
//        if (!last.isDigit() && last != '.') {
//            return false
//        }
//
//        val first = s[0]
//        if (s.length == 1) {
//            return first.isDigit()
//        }
//
//        var type: NumberType = when {
//            first.isDigit() -> Integer
//            first == '+' -> Integer
//            first == '-' -> Integer
//            first == '.' -> Decimal(hasDecimal = true)
//            else -> return false
//        }
//
//        for (i in 1..<s.length) {
//            val c = s[i]
//            when (type) {
//                is Integer -> when {
//                    c.isDigit() -> continue
//                    c == '.' -> {
//                        type = Decimal(hasDecimal = true)
//                        continue
//                    }
//                    c == 'e' || c == 'E' -> {
//                        type = Decimal(isSciNotation = true)
//                        continue
//                    }
//                    else -> return false
//                }
//                is Decimal -> when {
//                    c.isDigit() -> {
//                        continue
//                    }
//                    c == 'e' || c == 'E' -> {
//                        if (type.isSciNotation) {
//                            return false
//                        } else {
//                            type.isSciNotation = true
//                            continue
//                        }
//                    }
//                    c == '-' || c == '+' -> {
//                        if (type.isSciSigned) {
//                            return false
//                        } else {
//                            type.isSciSigned = true
//                            continue
//                        }
//                    }
//                    else -> return false
//                }
//            }
//        }
//
//        if (type is Decimal && !type.hasDecimal && !type.isSciSigned && !type.isSciNotation) {
//            return false
//        }
//
//        return true
//    }
}
