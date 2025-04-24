package leet.code.hard

import leet.code.Solution

class P1106ParsingABooleanExpression : Solution {

    override fun test() {
        println(parseBoolExpr("&(|(f))"))
    }

    private data class Op(val op: Char, val args: MutableList<Boolean> = mutableListOf())

    fun parseBoolExpr(expression: String): Boolean {
        val stack = mutableListOf(Op('_'))

        for (c in expression) when (c) {
            in "&!|" -> stack.add(Op(c))
            in "tf" -> stack.last().args.add(c == 't')
            ')' -> stack.removeLast().run {
                val value = when (op) {
                    '&' -> args.reduce(Boolean::and)
                    '|' -> args.reduce(Boolean::or)
                    '!' -> args.single().not()
                    else -> throw Exception()
                }
                stack.last().args.add(value)
            }
        }

        return stack.single().args[0]
    }
}