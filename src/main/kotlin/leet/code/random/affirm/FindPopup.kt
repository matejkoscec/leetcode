package leet.code.random.affirm

import leet.code.Solution

private data class DomNode(val name: String, var hidden: Boolean, val children: List<DomNode> = listOf()) {
    fun treeToString(): String = buildString {
        prettyPrint(this, this@DomNode, "", true)
    }

    private fun prettyPrint(builder: StringBuilder, node: DomNode, prefix: String, isLast: Boolean) {
        builder.append(prefix)
        builder.append(if (isLast) "└── " else "├── ")
        if (node.hidden) builder.append('(').append(node.name).append(')')
        else builder.append(node.name)
        builder.append("\n")

        val childPrefix = prefix + if (isLast) "    " else "│   "

        val lastIndex = node.children.size - 1
        for ((index, child) in node.children.withIndex()) {
            prettyPrint(builder, child, childPrefix, index == lastIndex)
        }
    }
}

class FindPopup : Solution {

    override fun test() {
        val root = DomNode(
            "ROOT", false, listOf(
                DomNode(
                    "B", false, listOf(
                        DomNode("F", false),
                        DomNode("G", false)
                    )
                ),
                DomNode("C", false),
                DomNode(
                    "D", false, listOf(
                        DomNode(
                            "POPUP", true, listOf(
                                DomNode("N", false),
                                DomNode("O", false),
                                DomNode("P", true)
                            )
                        ),
                        DomNode("I", false),
                        DomNode(
                            "J", false, listOf(
                                DomNode("Z", false),
                                DomNode("Y", false)
                            )
                        ),
                        DomNode("K", true)
                    )
                )
            )
        )
        println(root.treeToString())

        fun trace(node: DomNode): Int {
            if (node.name == "POPUP") return 1

            var found = -1
            var child: DomNode? = null
            for (c in node.children) {
                found = trace(c)
                if (found != -1) {
                    child = c
                    break
                }
            }
            if (found >= 0) {
                for (c in node.children) {
                    if (c != child) c.hidden = true
                }
                return found - 1
            }

            return -1
        }

        trace(root)

        println(root.treeToString())
    }
}