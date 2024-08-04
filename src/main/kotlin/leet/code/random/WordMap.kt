package leet.code.random

import leet.code.Solution

object WordMap : Solution {

    override fun test() {
        println(
            wordMap(
                arrayOf(
                    "@---A---+",
                    "        |",
                    "x-B-+   C",
                    "    |   |",
                    "    +---+",
                )
            )
        )
        println(
            wordMap(
                arrayOf(
                    "@         ",
                    "| C----+  ",
                    "A |    |  ",
                    "+---B--+  ",
                    "  |      x",
                    "  |      |",
                    "  +---D--+",
                )
            )
        )
    }

    private fun wordMap(map: Array<String>): String {
        var i = 0
        var j = 0
        outer@ for ((r, row) in map.withIndex()) {
            for ((c, char) in row.withIndex()) {
                if (char == '@') {
                    i = r
                    j = c
                    break@outer
                }
            }
        }

        var fromDirection: Direction? = null
        val path = StringBuilder()
        do {
            val nextMove = nextMove(i, j, map, fromDirection)
            path.append(map[i][j])
            when (nextMove) {
                Direction.LEFT -> {
                    j--
                    fromDirection = Direction.RIGHT
                }
                Direction.RIGHT -> {
                    j++
                    fromDirection = Direction.LEFT
                }
                Direction.UP -> {
                    i--
                    fromDirection = Direction.DOWN
                }
                Direction.DOWN -> {
                    i++
                    fromDirection = Direction.UP
                }
            }
        } while (map[i][j] != 'x')
        path.append('x')

        return path.toString()
    }

    private fun nextMove(i: Int, j: Int, map: Array<String>, from: Direction?): Direction {
        val left = if (j - 1 < 0) null else map[i][j - 1]
        val right = if (j + 1 > map[i].lastIndex) null else map[i][j + 1]
        val up = if (i - 1 < 0) null else map[i - 1][j]
        val down = if (i + 1 > map.lastIndex) null else map[i + 1][j]

        val current = map[i][j]
        val isJoint = current == '+' || current.isLetter()
        if (isPath(left)) {
            if (from == Direction.RIGHT || from == null) return Direction.LEFT
            if ((from == Direction.UP || from == Direction.DOWN) && isJoint) return Direction.LEFT
        }
        if (isPath(right)) {
            if (from == Direction.LEFT || from == null) return Direction.RIGHT
            if ((from == Direction.UP || from == Direction.DOWN) && isJoint) return Direction.RIGHT
        }
        if (isPath(up)) {
            if (from == Direction.DOWN || from == null) return Direction.UP
            if ((from == Direction.LEFT || from == Direction.RIGHT) && isJoint) return Direction.UP
        }
        if (isPath(down)) {
            if (from == Direction.UP || from == null) return Direction.DOWN
            if ((from == Direction.LEFT || from == Direction.RIGHT) && isJoint) return Direction.DOWN
        }

        throw Exception("Invalid path")
    }

    private fun isPath(c: Char?): Boolean = c != null && (c.isLetter() || c == '-' || c == '+' || c == '|')

    private enum class Direction { LEFT, RIGHT, UP, DOWN }
}
