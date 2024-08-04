package leet.code.util

class ListNode {
    var `val` = 0
    var next: ListNode? = null

    constructor()
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, next: ListNode?) {
        this.`val` = `val`
        this.next = next
    }

    override fun toString(): String {
        var node: ListNode? = this
        val nodes = mutableListOf<Int>()
        while (node != null) {
            nodes.add(node.`val`)
            node = node.next
        }

        return "[${nodes.joinToString()}]"
    }
}

inline fun node(`val`: Int, init: ListNode.() -> Unit = {}) = ListNode(`val`).apply(init)

fun Iterable<Int>.toLinkedList(): ListNode {
    val iterator = iterator()
    if (!iterator.hasNext()) return ListNode()

    val head = node(iterator.next())
    var current = head
    while (iterator.hasNext()) {
        current.next = node(iterator.next())
        current = current.next!!
    }

    return head
}

fun IntRange.toIntArray(): IntArray {
    if (last < first) {
        return IntArray(0)
    }

    val result = IntArray(last - first + 1)
    var index = 0
    for (element in this) {
        result[index++] = element
    }

    return result
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode(val=$`val`, left=$left, right=$right)"
    }
}

inline fun tnode(`val`: Int, init: TreeNode.() -> Unit = {}) = TreeNode(`val`).apply(init)
