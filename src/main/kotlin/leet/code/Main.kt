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
        .flatMap { if (it.isDirectory) it.listFiles()!!.asIterable() else listOf(it) }
        .filter { !it.isDirectory && it.nameWithoutExtension.contains(name, ignoreCase = true) }
    if (files.isEmpty()) {
        println("Solution $name not found")
        return
    }
    if (files.size > 1) {
        println("Multiple solutions found:\n${files.joinToString("\n") { it.nameWithoutExtension }}")
        return
    }

    files.single()
        .path
        .removePrefix("./src/main/kotlin/")
        .removeSuffix(".kt")
        .replace('/', '.')
        .also { println("==== $it ====") }
        .let { Class.forName(it).getConstructor().newInstance() as Solution }
        .test()
}
