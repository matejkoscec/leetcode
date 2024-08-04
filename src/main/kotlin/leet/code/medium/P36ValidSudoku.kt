package leet.code.medium

import leet.code.Solution

object P36ValidSudoku : Solution {

    override fun test() {
        println(
            isValidSudoku(
                arrayOf(
                    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
                )
            )
        )
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val quadrants = Array<MutableSet<Char>>(9) { mutableSetOf() }
        val rows = Array<MutableSet<Char>>(9) { mutableSetOf() }
        val cols = Array<MutableSet<Char>>(9) { mutableSetOf() }

        for (i in 0..<9) {
            for (j in 0..<9) {
                val char = board[i][j]
                if (char == '.') {
                    continue
                }

                val quadrant = (i / 3) * 3 + j / 3
                if (!rows[i].add(char) || !cols[j].add(char) || !quadrants[quadrant].add(char)) {
                    return false
                }
            }
        }

        return true
    }

    // First solution
//    fun isValidSudoku(board: Array<CharArray>): Boolean {
//        val quadrants = (1..9).associateWith { mutableSetOf<Char>() }
//
//        for (i in board.indices) {
//            val row = mutableSetOf<Char>()
//            val col = mutableSetOf<Char>()
//
//            for (j in 0..<9) {
//                val rowChar = board[i][j]
//                val colChar = board[j][i]
//                if (rowChar != '.' && !row.add(rowChar)) {
//                    return false
//                }
//                if (colChar != '.' && !col.add(colChar)) {
//                    return false
//                }
//
//                val rowCharQuadrant = (i / 3) * 3 + (j / 3) + 1
//                val colCharQuadrant = (j / 3) * 3 + (i / 3) + 1
//                if (i == j) {
//                    if (rowChar != '.' && !quadrants[rowCharQuadrant]!!.add(rowChar)) {
//                        return false
//                    }
//                } else if (j > i) {
//                    if (rowChar != '.' && !quadrants[rowCharQuadrant]!!.add(rowChar)) {
//                        return false
//                    }
//                    if (colChar != '.' && !quadrants[colCharQuadrant]!!.add(colChar)) {
//                        return false
//                    }
//                }
//            }
//        }
//
//        return true
//    }
}
