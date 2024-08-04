package leet.code.hard

import leet.code.Solution

object P68TextJustification : Solution {

    override fun test() {
        println(fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16))
        println(fullJustify(arrayOf("What", "must", "be", "acknowledgment", "shall", "be"), 16))
        println(
            fullJustify(
                arrayOf(
                    "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
                    "computer.", "Art", "is", "everything", "else", "we", "do"
                ), 20
            )
        )
    }

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val lines = mutableListOf<String>()

        var lineWords = mutableListOf<String>()
        var letterCount = 0
        for (word in words) {
            val wordCount = lineWords.size
            if (letterCount + word.length + wordCount - 1 < maxWidth) {
                letterCount += word.length
                lineWords.add(word)
                continue
            }

            val numOfSpaces = maxWidth - letterCount
            val spaces = if (wordCount > 1) numOfSpaces / (wordCount - 1) else numOfSpaces
            var extras = numOfSpaces - (wordCount - 1) * spaces

            val line = StringBuilder()
            repeat(wordCount - 1) { i ->
                line.append(lineWords[i])
                repeat(spaces) { line.append(' ') }
                if (extras > 0) {
                    line.append(' ')
                    extras--
                }
            }
            line.append(lineWords[wordCount - 1])
            if (wordCount == 1) repeat(spaces) { line.append(' ') }

            lines.add(line.toString())
            lineWords = mutableListOf(word)
            letterCount = word.length
        }

        val numOfSpaces = maxWidth - letterCount - lineWords.size
        val line = StringBuilder()
        for (word in lineWords) {
            line.append(word)
            if (line.length < maxWidth) line.append(' ')
        }
        repeat(numOfSpaces) { line.append(' ') }
        lines.add(line.toString())

        println(lines.all { it.length == maxWidth })

        return lines
    }
}
