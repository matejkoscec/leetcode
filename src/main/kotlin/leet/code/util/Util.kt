package leet.code.util

inline infix fun <T, R> T.into(any: (arg: T) -> R) = any(this)

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
