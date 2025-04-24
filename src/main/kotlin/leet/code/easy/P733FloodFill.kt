package leet.code.easy

import leet.code.Solution

class P733FloodFill : Solution {

    override fun test() {

    }

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val value = image[sr][sc]
        val seen = Array(image.size) { BooleanArray(image[0].size) }

        fun trace(i: Int, j: Int) {
            image[i][j] = color
            seen[i][j] = true
            if (i - 1 >= 0 && !seen[i - 1][j] && image[i - 1][j] == value) trace(i - 1, j)
            if (i + 1 < image.size && !seen[i + 1][j] && image[i + 1][j] == value) trace(i + 1, j)
            if (j - 1 >= 0 && !seen[i][j - 1] && image[i][j - 1] == value) trace(i, j - 1)
            if (j + 1 < image[0].size && !seen[i][j + 1] && image[i][j + 1] == value) trace(i, j + 1)
        }

        trace(sr, sc)

        return image
    }
}