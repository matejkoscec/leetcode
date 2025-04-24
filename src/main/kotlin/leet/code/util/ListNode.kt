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