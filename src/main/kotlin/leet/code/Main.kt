package leet.code

import java.io.File

fun interface Solution {
    fun test()
}

val folders = arrayOf("easy", "medium", "hard", "random")

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Specify the solution name")
        return
    }

    val name = args[0]
    val files = File("./src/main/kotlin/leet/code")
        .listFiles()!!
        .filter { it.isDirectory && it.nameWithoutExtension in folders }
        .flatMap { it.listFiles()!!.asIterable() }
        .filter { it.nameWithoutExtension.contains(name, ignoreCase = true) }
    if (files.isEmpty()) {
        println("Solution $name not found")
        return
    }
    if (files.size > 1) {
        println("Multiple solutions found:\n${files.joinToString("\n") { it.nameWithoutExtension }}")
        return
    }

    val className = files[0].path
        .removePrefix("./src/main/kotlin/")
        .removeSuffix(".kt")
        .replace('/', '.')
    val solution = Class.forName(className).getConstructor().newInstance() as Solution
    solution.test()
}
